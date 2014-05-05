package com.stringcalculatorproject;

public class InvalidInputException extends IllegalArgumentException {

    public InvalidInputException(String msg) {
        super(msg);
    }
}
