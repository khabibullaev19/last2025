package pack05scanner;

import java.util.Scanner;

public class ScannerClass {

    /*

        - Scanner Class:
        Scanner is a predefined class in Java used to take input from the user. It is present in the java.util
        package and supports different types of input such as integers, strings, float values, and characters.
        The Scanner class makes input handling simple and user-friendly in Java programs.

        - Used to read user input from keyboard.
        - Supports different data types like int, double, String etc.
        - Uses methods such as nextInt(), nextLine(), and nextDouble().

     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.println(num1 + " and " + num2);

    }

}
