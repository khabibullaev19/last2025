package pack06conditionalstatements;

import java.util.Scanner;

public class SwitchStatement {

    /*

        - Switch: Instead of writing many "if-else" statements,
                  you can use the "switch" statement.

        The "switch" expression is evaluated once.
        The result is compared with each "case" value.
        If there is a match, the matching block of code runs.
        The "break" statement stops the switch after matching case has run.
        The "default" statement runs if there is no matching case.

     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the food number: ");
        int foodNumber = scan.nextInt();
        scan.nextLine();

        switch (foodNumber) {
            case 1:
                System.out.println("Here is your \"Burger\".");
                break;
            case 2:
                System.out.println("Here is your \"Coffee\".");
                break;
            case 3:
                System.out.println("Here is your \"Pizza\".");
                break;
            case 4:
                System.out.println("Here is your \"Chicken\".");
                break;
            default:
                System.out.println("Invalid food number!");
        }

    }

}
