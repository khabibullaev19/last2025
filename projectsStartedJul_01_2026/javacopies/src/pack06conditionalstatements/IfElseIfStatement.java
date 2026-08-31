package pack06conditionalstatements;

import java.util.Scanner;

public class IfElseIfStatement {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        scan.nextLine();

        if (age < 18) {
            System.out.println("You are not eligible to work!!!");
        }else if (age <= 65) {
            System.out.println("You are eligible to work!!!");
        }else {
            System.out.println("You are retired!!!");
        }
        scan.close();

    }

}
