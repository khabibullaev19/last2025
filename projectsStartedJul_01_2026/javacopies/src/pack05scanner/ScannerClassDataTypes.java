package pack05scanner;

import java.util.Scanner;

public class ScannerClassDataTypes {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the price of a product: ");
        float price = scan.nextFloat();
        System.out.print("Enter the quantity of a product: ");
        int quantity = scan.nextInt();

        double totalPrice = price * quantity;

        System.out.printf("The total price is $%.2f%n", totalPrice);

    }

}
