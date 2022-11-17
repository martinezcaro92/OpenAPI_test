package com.testing.api;

public class TextResponse {
    private String message;
    private int httpCode;

    public TextResponse (String message, int httpCode) {
        this.message = message;
        this.httpCode = httpCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }
    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}
