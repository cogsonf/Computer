package view;

import model.CalculatorModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorView {
    private final double MIN_OPERAND = -10000.0;
    private final double MAX_OPERAND = 10000.0;

    private double temporaryResult = 0.0;

    public void displayMenu() {
        System.out.println("=====Calculator Program=====");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
    }

    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    public void displayBMIStatus(CalculatorModel.BMI bmiStatus) {
        System.out.println("BMI Status: " + bmiStatus);
    }

    public double getNumberInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double number = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                number = scanner.nextDouble();

                if (number >= MIN_OPERAND && number <= MAX_OPERAND) {
                    validInput = true;
                } else {
                    System.out.println("Operand must be in the range [-10000, 10000]. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }

        return number;
    }

    public CalculatorModel.Operator getOperatorInput() {
        Scanner scanner = new Scanner(System.in);
        CalculatorModel.Operator operator = null;
        while (operator == null) {
            System.out.print("Enter operator (+, -, *, /, ^, =): ");
            String input = scanner.next().trim();

            try {
                operator = convertToOperator(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return operator;
    }

    private CalculatorModel.Operator convertToOperator(String operator) {
        switch (operator) {
            case "+":
                return CalculatorModel.Operator.ADDITION;
            case "-":
                return CalculatorModel.Operator.SUBTRACTION;
            case "*":
                return CalculatorModel.Operator.MULTIPLICATION;
            case "/":
                return CalculatorModel.Operator.DIVISION;
            case "^":
                return CalculatorModel.Operator.EXPONENTIATION;
            case "=":
                return CalculatorModel.Operator.EQUALS;
            default:
                throw new IllegalArgumentException("Invalid operator. Please enter a valid operator.");
        }
    }

    public void setTemporaryResult(double result) {
        this.temporaryResult = result;
    }

    public double getTemporaryResult() {
        return temporaryResult;
    }
}
