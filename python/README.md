# PYTHON FAST API

## Required dependencies before launch it
``` 
pip install fastapi
pip install "uvicorn[standard]"
pip install "python-jose[cryptography]"
pip install "passlib[bcrypt]"
```

OpenSSL is on C:\ProgramFiles\Git\usr\bin\openssl.exe

## Launch process Windows with log file
> python3 -m uvicorn main:app --reload > uvicorn.log