package org.example;

import org.example.operation.MultiplyOperation;
import org.example.operation.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuiltiplyOperationTest {

    private final Operation operation = new MultiplyOperation();

    @Test
    @DisplayName("Пользователь может умножить два положительных числа")
    void shouldMultiplyPositiveDigital() {
        double result = operation.calculate(5,5);
        assertEquals(25, result);
    }

    @Test
    @DisplayName("Пользователь может умножить положительное на отрицательное число")
    void shouldMultiplyPositiveAndNegativeDigital() {
        double result = operation.calculate(10,-5);
        assertEquals(-50, result);
    }

    @Test
    @DisplayName("Пользователь может умножить два отрицательных числа")
    void shouldMultiplyNegativeDigital() {
        double result = operation.calculate(-15,-5);
        assertEquals(75, result);
    }

    @Test
    @DisplayName("Пользователь может умножить на 0")
    void shouldMultiplyByZero() {
        double result = operation.calculate(20,0);
        assertEquals(0, result);
    }
}
