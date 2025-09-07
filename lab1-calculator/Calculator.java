import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){ 
        Scanner scan = new Scanner(System.in);
        double num1, num2, result = 0;
        char operator;
        while (true) {
            System.out.println("Enter the first number or type '0' to quit:");
            num1 = scan.nextDouble();
            if (num1 == 0) {
                System.out.println("Exiting.");
                break;
            }
            System.out.println("Enter an operator (+, -, *, /):");
            operator = scan.next().charAt(0);

            System.out.println("Enter the second number:");
            num2 = scan.nextDouble();

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
                    continue;
            }
            System.out.println("Result: " + result);
        }
    }
}
