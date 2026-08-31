package pack06conditionalstatements;

import java.util.Scanner;

public class IfElseTask {

    public static void main(String[] args) {

        /*
            Task: Calculate Price and Calories of a Cappucino

            Given a variable named Size, write a program that displays the price and calorie information for
            a cappucino basen on its size. The valid cappucino sizes are "tall", "grande", and "venti".
            Each with its associated price and calorie values.

                Valid Sizes and Their information:
                    Tall:
                        Price: $3.69
                        Calories: 90

                    Grande:
                        Price: $3.99
                        Calories: 120

                    Venti:
                        Price: $4.29
                        Calories: 150

                    If the Size is invalid, the program should display "Invalid Size".
         */

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of order(Tall | Grande | Venti): ");
        String size = scan.nextLine();

        double price = 0;
        int calories = 0;

        if (size.equalsIgnoreCase("Grande") || size.equalsIgnoreCase("Venti") || size.equalsIgnoreCase("Tall")) {

            if (size.equalsIgnoreCase("Tall")){
                price = 3.69;
                calories = 90;
            }else if (size.equalsIgnoreCase("Grande")){
                price = 3.99;
                calories = 120;
            }else if (size.equalsIgnoreCase("Venti")){
                price = 4.29;
                calories = 150;
            }

            System.out.printf("You have chosen %s, its price is $%.2f, and calories %d.",size.toUpperCase(),price,calories);

        }else {
            System.out.println("Invalid Size!!!");
        }

    }

}
