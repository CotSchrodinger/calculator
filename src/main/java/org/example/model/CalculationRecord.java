package org.example.model;

public class CalculationRecord {
    private double a;
    private double b;
    private String operationName;
    private double result;

    public CalculationRecord(double a, double b, String operationName, double result) {
        this.b = b;
        this.a = a;
        this.operationName = operationName;
        this.result = result;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getOperationName() {
        return operationName;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CalculationRecord{" +
                "a=" + a +
                ", b=" + b +
                ", operationName='" + operationName + '\'' +
                ", result=" + result +
                '}';
    }
}
