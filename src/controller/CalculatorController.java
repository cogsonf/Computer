package controller;

import model.CalculatorModel;
import view.CalculatorView;

import java.util.Scanner;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void runCalculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    performNormalCalculator();
                    break;
                case 2:
                    performBMICalculator();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void performNormalCalculator() {
        double result = 0.0;
    	System.out.println("---Normal Calculator---");

        while (true) {
            double operand1 = (result == 0.0) ? view.getNumberInput("Enter the first number: ") : view.getTemporaryResult();
            CalculatorModel.Operator operator = view.getOperatorInput();

            if (operator == CalculatorModel.Operator.EQUALS) {
                break;
            }

            double operand2 = view.getNumberInput("Enter the next number: ");
            result = model.calculate(operand1, operator, operand2);
            view.setTemporaryResult(result); // Store the result in the temporary variable
        }

        view.displayResult(result);
    }

    private void performBMICalculator() {
    	System.out.println("---BMI Calculator---");

    	
        double weight = view.getNumberInput("Enter your weight (kg): ");
        double height = view.getNumberInput("Enter your height (cm): ");

        CalculatorModel.BMI bmiStatus = model.calculateBMI(weight, height);
        view.displayBMIStatus(bmiStatus);
    }
}
