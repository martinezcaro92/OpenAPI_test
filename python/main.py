from typing import Union, List
import uuid
from datetime import datetime, timedelta

from fastapi import FastAPI, HTTPException, Body, status, Form, File, UploadFile, Depends
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm
from jose import JWTError, jwt
from passlib.context import CryptContext
from pydantic import BaseModel, Field

SECRET_KEY = "0b6749cf8a80dc638b71ca058f01c4f8a5d602f1c31904131f0ea3e8e2c8ce98"
ALGORITHM = "HS256"
ACCESS_TOKEN_EXPIRE_MINUTES = 30

class Item(BaseModel):
    name: str
    price: float
    is_offer: Union[bool, None] = None

class Parents (BaseModel):
    mum: str
    dad: str

class Student(BaseModel):
    id: int = Field(default=None, title="Identifies the student by a id number")
    name: str = Field(default="Perico", title="Identifies the student by a name", max_length=300)
    surname: str
    age: int
    address: List[str] = Field(default=["hola", "Adios"], title="Identifies the student by a name", max_length=300)
    parents : Parents
    launch: bool
"""     created: datetime
    uuid: uuid.UUID """

class Token(BaseModel):
    access_token: str
    token_type: str

class TokenData(BaseModel):
    username: str | None = None

class User(BaseModel):
    username: str
    email: str | None = None
    full_name: str | None = None
    disabled: bool | None = None

class UserInDB(User):
    hashed_password: str

example = { 
    "normal": {
        "summary": "normal example",
        "description": "A **normal** example working",
        "value": {
            "id": 0,
            "name": "Angustias",
            "surname": "Normales",
            "age": 30,
            "address":  ["Calle Castillo", "Caravaca"],
            "parents": {"mum": "Gloria", "dad": "Camilo"},
            "launch": False
        }
    }, 
    "advanced": {
        "summary": "advanced example",
        "description": "A **advanced** example working",
        "value": {
            "id": 0,
            "name": "Angustias",
            "surname": "advanced",
            "age": 30,
            "address":  ["Calle Cartagena", "Murcia"],
            "parents": {"mum": "Eugenia", "dad": "Pepe"},
            "launch": False
        }
    }, 
    "supreme": {
        "summary": "supreme example",
        "description": "A **supreme** example working",
        "value": {
            "id": 0,
            "name": "Angustias",
            "surname": "supreme",
            "age": 30,
            "address":  ["Avenida Peligro", "Lorca"],
            "parents": {"mum": "Inma", "dad": "Isma"},
            "launch": False
        }
    }
}


fake_users_db = {
    "johndoe": {
        "username": "johndoe",
        "full_name": "John Doe",
        "email": "johndoe@example.com",
        "hashed_password": "$2b$12$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGga31lW",
        "disabled": False,
    }
}

oauth2_scheme = OAuth2PasswordBearer(tokenUrl="token")
pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

app = FastAPI(
    title="FastAPI testing",
    description="Example v0.1 of the fastAPI using Python",
    version="0.0.1",
    terms_of_service="https://e-lighthouse.com",
    contact={
        "name":"E-ligthouse support site",
        "url": "https://e-lighthouse.com",
        "email":"jmmartinez@e-lighthouse.com"},
    license_info={
        "name":"Apache 2.0",
        "url": "https://www.apache.org/licenses/LICENSE-2.0.html"
    }
)

def verify_password(plain_password, hashed_password):
    return pwd_context.verify(plain_password, hashed_password)

def get_password_hash(password):
    return pwd_context.hash(password)

def get_user(db, username: str):
    if username in db:
        user_dict = db[username]
        return UserInDB(**user_dict)

def authenticate_user(fake_db, username: str, password: str):
    user = get_user(fake_db, username)
    if not user:
        return False
    if not verify_password(password, user.hashed_password):
        return False
    return user

def create_access_token(data: dict, expires_delta: timedelta | None = None):
    to_encode = data.copy()
    if expires_delta:
        expire = datetime.utcnow() + expires_delta
    else:
        expire = datetime.utcnow() + timedelta(minutes=15)
    to_encode.update({"exp": expire})
    encoded_jwt = jwt.encode(to_encode, SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt


async def get_current_user(token: str = Depends(oauth2_scheme)):
    credentials_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Could not validate credentials",
        headers={"WWW-Authenticate": "Bearer"},
    )
    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=[ALGORITHM])
        username: str = payload.get("sub")
        if username is None:
            raise credentials_exception
        token_data = TokenData(username=username)
    except JWTError:
        raise credentials_exception
    user = get_user(fake_users_db, username=token_data.username)
    if user is None:
        raise credentials_exception
    return user


async def get_current_active_user(current_user: User = Depends(get_current_user)):
    if current_user.disabled:
        raise HTTPException(status_code=400, detail="Inactive user")
    return current_user


@app.post("/token", response_model=Token, include_in_schema=False)
async def login_for_access_token(form_data: OAuth2PasswordRequestForm = Depends()):
    user = authenticate_user(fake_users_db, form_data.username, form_data.password)
    if not user:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Incorrect username or password",
            headers={"WWW-Authenticate": "Bearer"},
        )
    access_token_expires = timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    access_token = create_access_token(
        data={"sub": user.username}, expires_delta=access_token_expires
    )
    return {"access_token": access_token, "token_type": "bearer"}


@app.get("/users/me/", response_model=User)
async def read_users_me(current_user: User = Depends(get_current_active_user)):
    return current_user


@app.get("/users/me/items/")
async def read_own_items(current_user: User = Depends(get_current_active_user)):
    return [{"item_id": "Foo", "owner": current_user.username}]

@app.get("/")
async def read_root():
    return {"Hello": "World"}


@app.get("/items/{item_id}")
async def read_item(item_id: int, q: Union[str, None] = None):
    return {"item_id": item_id, "q": q}


@app.put("/items/{item_id}")
async def update_item(item_id: int, item: Item):
    return {"item_name": item.name, "item_id": item_id}

@app.post("/student", response_model=Student, status_code=status.HTTP_201_CREATED)
async def create_student(student_id:int, student:Student = Body(examples=example), current_user: User = Depends(get_current_active_user)):
    if student_id<5:
        raise HTTPException(status_code=499, detail="Agárrala con la mano")
    
    return student

@app.get("/student/{mode}", response_model=Student, response_model_include=["name", "age"])
async def read_student(student_mode:str): 
    print(example[student_mode])  
    return example[student_mode]["value"]