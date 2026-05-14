package org.example;

import org.example.operation.AddOperation;
import org.example.operation.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOperationTest {

    private final Operation operation = new AddOperation();

    @Test
    @DisplayName("Пользователь может сложить положительные числа")
    void shouldAddPositiveDigital() {
        double result = operation.calculate(10, 10);
        assertEquals(20.0, result);
    }

    @Test
    @DisplayName("Пользователь может сложить положительное число с отрицательным")
    void shouldAddPositiveAndNegativeDigital() {
        double result = operation.calculate(-10, 10);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Пользователь может сложить положительное число с отрицательным")
    void shouldAddNegativeDigital() {
        double result = operation.calculate(-10, -10);
        assertEquals(-20.0, result);
    }
}
