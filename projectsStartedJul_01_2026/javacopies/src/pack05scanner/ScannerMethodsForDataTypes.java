package pack05scanner;

import java.util.Scanner;

public class ScannerMethodsForDataTypes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter you gender: ");
        char gender = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter your street address: ");
        String streetAddress = scanner.nextLine();

        System.out.print("Enter your postal code: ");
        String postalCode = scanner.nextLine();

        System.out.print("Enter your salary: ");
        float salary = scanner.nextFloat();

        System.out.printf("Hello %s %s.\nYou are %c and your age is %d.\nIt seems your mail is %s and salary %.2f.\n" +
                "By the way, your phone number is %s and street address is %s.",firstName,lastName,gender,age,email,salary,phoneNumber,streetAddress);

    }
}
