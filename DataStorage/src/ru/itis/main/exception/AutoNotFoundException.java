package ru.itis.main.exception;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public class AutoNotFoundException extends RuntimeException{
    public AutoNotFoundException(String message){
        super(message);
    }
}
