package com.vafgrant.qa.test.exception;

public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException(String errorMessage) { super(errorMessage); }
}
