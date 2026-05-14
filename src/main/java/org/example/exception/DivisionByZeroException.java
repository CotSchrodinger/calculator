package org.example.exception;

public class DivisionByZeroException extends CalculatorException{
    public DivisionByZeroException() {
        super("Division by zero is not allowed");
    }
}
