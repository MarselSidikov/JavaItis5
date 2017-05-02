package ru.itis.main.exception;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
