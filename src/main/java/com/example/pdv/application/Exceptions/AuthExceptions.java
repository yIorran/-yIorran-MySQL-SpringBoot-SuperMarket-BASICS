package com.example.pdv.application.Exceptions;

public class AuthExceptions extends Exception {

    public AuthExceptions(String msg) {
        super(msg);
    }

    public String msg (String msg){
        return msg;
    }

}
