package org.example.operation;

import org.example.exception.DivisionByZeroException;

public class DivideOperation implements Operation{
    @Override
    public double calculate(double a, double b) {
        if(b == 0) { throw new DivisionByZeroException();}
        return a / b;
    }
}
