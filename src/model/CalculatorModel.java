package model;

public class CalculatorModel {
    public enum Operator {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, EXPONENTIATION, EQUALS
    }

    public enum BMI {
        UNDER_STANDARD, STANDARD, OVERWEIGHT, FAT_LOSE_WEIGHT, VERY_FAT_LOSE_IMMEDIATELY
    }

    private double memoryResult;

    public CalculatorModel() {
        this.memoryResult = 0.0;
    }

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("Error: Division by zero!");
                    return Double.NaN;
                }
            case EXPONENTIATION:
                return Math.pow(a, b);
            case EQUALS:
                return memoryResult; 
            default:
                System.out.println("Invalid operator");
                return Double.NaN;
        }
    }

    public BMI calculateBMI(double weight, double height) {
        double bmi = weight / Math.pow(height / 100, 2);

        if (bmi < 19) {
            return BMI.UNDER_STANDARD;
        } else if (bmi <= 25) {
            return BMI.STANDARD;
        } else if (bmi <= 30) {
            return BMI.OVERWEIGHT;
        } else if (bmi <= 40) {
            return BMI.FAT_LOSE_WEIGHT;
        } else {
            return BMI.VERY_FAT_LOSE_IMMEDIATELY;
        }
    }

    public void storeResult(double result) {
        this.memoryResult = result;
    }
}
