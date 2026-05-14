# Calculator

Учебный проект на Java — консольный калькулятор с историей вычислений.

## Стек

- Java 17
- Gradle

## Структура проекта

```
src/main/java/org/example/
├── Calculator.java               — основной класс калькулятора
├── operation/
│   ├── Operation.java            — функциональный интерфейс операции
│   ├── AddOperation.java
│   ├── SubtractOperation.java
│   ├── MultiplyOperation.java
│   └── DivideOperation.java
├── model/
│   └── CalculationRecord.java    — запись об одном вычислении
├── history/
│   └── CalculationHistory.java   — история всех вычислений
├── exception/
│   ├── CalculatorException.java
│   └── DivisionByZeroException.java
└── exercices/                    — учебные упражнения по темам
```

## Как работает

`Calculator` принимает операцию через интерфейс `Operation` и два числа. Результат записывается в `CalculationHistory`.

```java
Calculator calc = new Calculator();
calc.calculate(new AddOperation(), "add", 10, 5);       // 15.0
calc.calculate(new DivideOperation(), "divide", 10, 2); // 5.0

calc.getHistory().getAll();                  // все записи
calc.getHistory().getLast(2);               // последние 2
calc.getHistory().filterByOperation("add"); // только сложения
calc.getHistory().sumOfResults();           // сумма всех результатов
```

## Запуск

```bash
./gradlew run
```

## Тесты

```bash
./gradlew test
```

Покрыты: `AddOperation`, `SubtractOperation`, `MultiplyOperation`, `DivideOperation`.
