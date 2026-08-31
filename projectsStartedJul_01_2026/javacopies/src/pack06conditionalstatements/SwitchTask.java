package pack06conditionalstatements;

import java.util.Scanner;

public class SwitchTask {

    /*
            Task: Build a Basic Calculator

            You are provided with two double variables, num1 and num2, and a character variable named operator.
            Write a program that calculates the result based on the given math operator.
            If the operator is invalid, the program should return a result of 0.

                The program should accept the following math operators:
                    addition (+), subtraction (-), division (/), multiplication (*), and module (%).

                        Ex:
                            num1 = 2.5
                            num2 = 20.5
                            operator = '+'

                        Output: 23.0
         */

    public static void main(String[] args) {

        double num1 = 0;
        double num2 = 0;
        char operator;
        double result = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        num1 = input.nextDouble();
        input.nextLine();

        System.out.print("Enter number 2: ");
        num2 = input.nextDouble();
        input.nextLine();

        System.out.print("Enter operator (+, -, *, /, %): ");
        operator = input.next().charAt(0);

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case  '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case  '/':
                result = num1 / num2;
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                System.out.println("Invalid input");
        }

        System.out.println("The result is: " + result);

    }

}
