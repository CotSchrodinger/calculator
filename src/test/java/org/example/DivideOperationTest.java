package org.example;

import org.example.exception.DivisionByZeroException;
import org.example.operation.DivideOperation;
import org.example.operation.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideOperationTest {

    private final Operation operation = new DivideOperation();

    @Test
    @DisplayName("Пользователь может разделить положительные числа")
    void shouldDividePositiveDigital() {
        double result = operation.calculate(15, 10);
        assertEquals(1.5, result);
    }

    @Test
    @DisplayName("Пользователь может разделить положительные числа")
    void shouldDividePositiveAndNegativeDigital() {
        double result = operation.calculate(20, -10);
        assertEquals(-2.0, result);
    }

    @Test
    @DisplayName("Пользователь может разделить положительные числа")
    void shouldDivideNegativeDigital() {
        double result = operation.calculate(-61, -10);
        assertEquals(6.1, result);
    }

    @Test
    @DisplayName("Пользователь не может разделить на 0")
    void shouldNotDivideByZero() {
        assertThrows(DivisionByZeroException.class, () -> operation.calculate(10, 0));
    }
}
