package org.example.history;

import org.example.model.CalculationRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalculationHistory {
    private List<CalculationRecord> calculationRecordList = new ArrayList<>();

    public void add(CalculationRecord record) {
        calculationRecordList.add(record);
    }

    public List<CalculationRecord> getAll() {
        List<CalculationRecord> result = new ArrayList<>();
         result.addAll(calculationRecordList);
         return result;
    }

    public List<CalculationRecord> getLast(int n) {
        if(n > calculationRecordList.size()) { return new ArrayList<>(calculationRecordList); }
        List<CalculationRecord> view = calculationRecordList.subList(calculationRecordList.size() - n, calculationRecordList.size());
        return new ArrayList<>(view);
    }

    public void clear() {
        calculationRecordList.clear();
    }

    public List<CalculationRecord>filterByOperation(String operationName) {
        return calculationRecordList.stream()
                .filter(op -> op.getOperationName().equals(operationName))
                .toList();
    }

    public Optional<CalculationRecord> findLastByOperation(String operationName) {
        return calculationRecordList.stream()
                .filter(op -> op.getOperationName().equals(operationName))
                .reduce((a, b) -> b);
    }

    public double sumOfResults() {
        return calculationRecordList.stream()
                .mapToDouble(r -> r.getResult())
                .sum();
    }
}
