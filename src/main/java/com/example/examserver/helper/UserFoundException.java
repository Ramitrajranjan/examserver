package com.example.examserver.helper;

public class UserFoundException extends Exception{
    public UserFoundException()
    {
        super("user with this username is already present in DB");
    }
    public UserFoundException(String msg)
    {
        super(msg);
    }
}
