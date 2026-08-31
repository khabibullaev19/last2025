package pack06conditionalstatements;

import java.util.Scanner;

public class SwitchWithArrow {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number 1: ");
        double number1 = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the number 2: ");
        double number2 = input.nextDouble();
        input.nextLine();

        System.out.print("Enter the operator(+|-|*|/|%): ");
        char operator = input.next().charAt(0);

        double result = switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            case '%' -> number1 % number2;
            default -> {
                System.out.println("Invalid operator");
                yield 0;// here we need yield since we do not producing any result,
                        // instead of "sout" we could use "result = 0;"
            }
        };
        System.out.println("The result is: " + result);

    }

}
