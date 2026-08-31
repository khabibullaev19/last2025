package pack06conditionalstatements;

import java.util.Scanner;

public class NestedTernary {

    public static void main(String[] args) {

        int value;
        String result;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        value = scan.nextInt();
        scan.nextLine();

        result = value % 100 == 0 ? (value % 400 == 0 ? "Leap year!" : "Not a leap year!") : (value % 4 == 0 ? "Leap" : "Not Leap");
        System.out.println(result);
        scan.close();

    }

}
