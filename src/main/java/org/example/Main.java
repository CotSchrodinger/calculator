package org.example;

import org.example.exercices.BankAccount;
import org.example.exercices.Circle;
import org.example.exercices.Farewell;
import org.example.exercices.FormalGreeter;
import org.example.exercices.Greeter;
import org.example.exercices.ImageDocument;
import org.example.exercices.InformalGreeter;
import org.example.exercices.PoliteBot;
import org.example.exercices.Printable;
import org.example.exercices.Rectangle;
import org.example.exercices.Shape;
import org.example.exercices.SpreadsheetDocument;
import org.example.exercices.TextDocument;
import org.example.operation.AddOperation;
import org.example.operation.Operation;
import org.example.operation.SubtractOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void printGreeting(Greeter greeter, String name) {System.out.println(greeter.greet(name));}
    public static void printAll(List<Printable> items) { for (Printable item : items) {item.print();}}
    public static List<Integer> getLast(List<Integer> list, int n) {
        if(n > list.size()) { return new ArrayList<>(list); }
        List<Integer> view = list.subList(list.size() - n, list.size());
        return new ArrayList<>(view);
    }

    static List<String> filter(List<String> list, Predicate<String> predicate) {
        return list.stream()
                .filter(predicate)
                .toList();
    }


    public static void main(String[] args) {

        Greeter formal = new FormalGreeter();
        Greeter informal = new InformalGreeter();

        System.out.println(formal.greet("Mike"));
        System.out.println(informal.greet("Victoria"));

        printGreeting(formal, "Violetta");
        printGreeting(informal, "George");

        PoliteBot politeBot = new PoliteBot();

        Greeter var1 = politeBot;
        Farewell var2 = politeBot;

        System.out.println(var1.greet("Lu"));
        System.out.println(var2.sayBye("Lu"));

        Shape circle = new Circle("red","Круг", 10.1);
        Shape rectangle = new Rectangle("black","прямоугольник", 10.5, 2);

        System.out.println(circle.describe());
        System.out.println(rectangle.describe());

        System.out.println("=======================================");

        List<Shape> shapeList = List.of(circle, rectangle);
        for (Shape shape : shapeList) {
            System.out.println(shape.describe());
        }

        List<Printable> itemList = List.of(new ImageDocument(), new SpreadsheetDocument(), new TextDocument());
        printAll(itemList);

        System.out.println("=======================================");
        BankAccount bankAccount = new BankAccount(1000);
//        try {
//            bankAccount.freeze();
//            bankAccount.withdraw(2500);
//        } catch (BankException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        } bankAccount.deposit(1000);
//
//        System.out.println(bankAccount.getBalance());

        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(getLast(list, 11));

        Map<String, Integer> resultList = new HashMap<>();
        String text = "hello world hello java world hello";
        String [] words = text.split(" ");

        for (String word : words) {
            resultList.put(word, resultList.getOrDefault(word, 0) + 1);
        }
        System.out.println(resultList);
        System.out.println("================================");

        Predicate<String> isTrue = s -> s.length() > 5;
        System.out.println(isTrue.test("123456"));

        Function<String ,String> stringStringFunction = s -> s.toUpperCase();
        System.out.println(stringStringFunction.apply("sffgdfgfg"));

        Consumer<String> addFrefix = s -> System.out.println(">>" + s);
        addFrefix.accept("fjfjjfjfjf");


        List<String> listOfWords = List.of("яблоко", "анонс", "Рудимент", "окно", "картофель");

        System.out.println(filter(listOfWords, s -> s.length() > 4));
        System.out.println(filter(listOfWords, s -> s.startsWith("а")));
        System.out.println(filter(listOfWords, s -> s.contains("о")));

        Operation addOperation = new AddOperation();
        Operation subtractOperation = new SubtractOperation();
        Calculator calculator = new Calculator();

        System.out.println(calculator.calculate(addOperation, "+", 10, 10));
        System.out.println(calculator.calculate(subtractOperation, "-", 10, 10));
        System.out.println(calculator.calculate((a, b) -> a * b, "*", 10, 10));
        System.out.println(calculator.calculate((a, b) -> a / b, "/", 10, 10));

        System.out.println(calculator.getHistory().getAll());

        List<String> words1 = List.of("apple", "banana", "avocado", "cherry", "apricot", "blueberry");

        List<String> result1 = words1.stream()
                .filter(w -> w.startsWith("a"))
                .map(w -> w.toUpperCase())
                .toList();

        System.out.println(result1);

        long result2 = words1.stream()
                .filter(w -> w.length() > 6)
                .count();

        System.out.println(result2);

        String finalResult = words1.stream()
                .filter(w -> w.contains("e"))
                .findFirst()
                .orElse("не найдено");

        System.out.println(finalResult);


    }
}