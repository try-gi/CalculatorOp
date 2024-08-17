package com.calculatoroperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteractiveCalculator {
    private static List<String> history = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter two numbers to operate, type 'history' to see history, type 'exit' to quit):");

            // Read user input
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exited");
                break;
            }
            
            if (input.equalsIgnoreCase("history")) {
                viewHistory();
                continue;
            }
            
            double num1, num2;
            try {
                num1 = Double.parseDouble(input);
                System.out.print("Enter the second number: ");
                num2 = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                continue;
            }

            System.out.println("Choose an operation: +, -, *, /");
            String operation = scanner.nextLine().trim();

            double result;
            try {
                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid operation. Please choose one of: +, -, *, /");
                        continue;
                }
                
                String resultString = num1 + " " + operation + " " + num2 + " = " + result;
                history.add(resultString);
                System.out.println(resultString);

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("History:");
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}
