package com.example.demo.util;

public class LegacyBean {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    public void init() {
        System.out.println("LegacyBean initialized with message: " + message);
    }
}
