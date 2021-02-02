package com.calculator;

import com.calculator.exception.DividedByZeroException;
import com.calculator.exception.NegativeDegreeException;

import java.util.*;

public class APICalculator {
    private static final Map<String, Integer> priorities = new HashMap<>();

    static {
        priorities.put("(", -1);
        priorities.put(")", -1);
        priorities.put("+", 1);
        priorities.put("-", 1);
        priorities.put("*", 2);
        priorities.put("/", 2);
        priorities.put("^", 3);
    }

    public static double calculate(String expression) {
        Stack<Double> numbers = new Stack<>();
        Queue<String> queue = new ArrayDeque<>(getRPN(expression));

        while (queue.size() != 0) {
            if (priorities.containsKey(queue.peek())) {
                double first = numbers.pop();
                double second = numbers.pop();

                switch (Objects.requireNonNull(queue.poll())) {
                    case "+":
                        numbers.push(first + second);
                        break;
                    case "-":
                        numbers.push(second - first);
                        break;
                    case "*":
                        numbers.push(first * second);
                        break;
                    case "/":
                        if (first == 0) {
                            throw new DividedByZeroException();
                        }
                        numbers.push(second / first);
                        break;
                    case "^":
                        if (first < 0) {
                            throw new NegativeDegreeException();
                        } else {
                            numbers.push(Math.pow(second, first));
                        }
                        break;
                }
            } else {
                numbers.push(Double.parseDouble(queue.poll()));
            }
        }
        return numbers.pop();
    }

    private static Stack<String> getRPN(String expression) {
        Stack<String> operands = new Stack<>();
        Stack<String> integers = new Stack<>();

        String[] expressionSymbols = expression
                .replace(" ", "")
                .split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)");
        for (String currentSymbol : expressionSymbols) {
            if (priorities.containsKey(currentSymbol)) {
                if (operands.size() != 0) {
                    if (currentSymbol.equals(")")) {
                        while (operands.size() != 0) {
                            if (!operands.peek().equals("(")) {
                                integers.push(operands.pop());
                            } else {
                                operands.pop();
                                break;
                            }
                        }
                        continue;
                    }

                    if (currentSymbol.equals("(")) {
                        operands.push(currentSymbol);
                        continue;
                    }

                    if (priorities.get(operands.peek()) > priorities.get(currentSymbol) ||
                            priorities.get(operands.peek()).equals(priorities.get(currentSymbol))) {
                        integers.push(operands.pop());
                    }
                }
                operands.push(currentSymbol);
            } else {
                integers.push(currentSymbol);
            }
        }
        while (operands.size() != 0) {
            integers.push(operands.pop());
        }

        return integers;
    }
}
