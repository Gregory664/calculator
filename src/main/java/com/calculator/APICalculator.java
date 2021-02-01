package com.calculator;

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
