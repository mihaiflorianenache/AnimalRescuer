package org.fasttrackit;

public class MyException extends Exception{
    String message;
    MyException(String message)
    {
        this.message=message;
    }

    public String toString()
    {
        return message;
    }
}
