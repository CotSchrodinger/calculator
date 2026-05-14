package org.example;

import org.example.operation.Operation;
import org.example.operation.SubtractOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractOperationTest {

    private final Operation operation = new SubtractOperation();

    @Test
    @DisplayName("Пользователь может отнять из положительных чисел")
    void shouldSubtractPositiveDigital() {
        double result = operation.calculate(15, 9);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Пользователь может отнять положительного числа отрицательное")
    void shouldSubtractPositiveAndNegativeDigital() {
        double result = operation.calculate(15, -9);
        assertEquals(24, result);
    }

    @Test
    @DisplayName("Пользователь может отнять положительного числа отрицательное")
    void shouldSubtractNegativeDigital() {
        double result = operation.calculate(-43, -9);
        assertEquals(-34, result);
    }

    @Test
    @DisplayName("Пользователь может отнять положительного числа отрицательное")
    void shouldSubtractByZero() {
        double result = operation.calculate(43, 0);
        assertEquals(43, result);
    }
}
