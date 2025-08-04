import java.util.Scanner;

public class Calculator {

    //addition
    public static double add(double a, double b) {
        return a + b;
    }

    //subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    //multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    //division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        System.out.println("----------Java Console Calculator----------");

        while (continueCalc) {
            System.out.print("\nEnter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operator!");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }

            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            continueCalc = choice.equals("yes");
        }

        System.out.println("Calculator closed. Goodbye!");
        scanner.close();
    }
}