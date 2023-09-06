package com.example.callToApi.exceptions;

public class DriverNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DriverNotFoundException(String msg) {
        super(msg);
    }
}

