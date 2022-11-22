package com.contact.application.exception;

public class NoDuplicateEmailIdException extends Exception{
    public NoDuplicateEmailIdException (String message) {
        super(message);
    }
}
