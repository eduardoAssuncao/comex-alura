package br.com.alura.utils;

public class ExceptionMessage extends RuntimeException{

    public String message;

    public ExceptionMessage(String message){
        super(message);
    }
}
