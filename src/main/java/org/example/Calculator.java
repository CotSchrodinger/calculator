package org.example;

import org.example.history.CalculationHistory;
import org.example.model.CalculationRecord;
import org.example.operation.Operation;

public class Calculator {
    private CalculationHistory history = new CalculationHistory();
    public double calculate(Operation op, String operationName, double a, double b) {
        double result = op.calculate(a, b);
        CalculationRecord record = new CalculationRecord(a, b, operationName, result);
        history.add(record);
        return result;
    }

    public CalculationHistory getHistory() {
        return history;
    }
}
