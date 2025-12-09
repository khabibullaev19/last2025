package javaprogrammingchallengespdf;

import java.util.Scanner;

public class Code01 {

    /*
        Write a program to print the reverse of the String?
            Ex: Nacre
            Output: ercaN
     */

    private static String reverse(String word) {
        String result = "";

        for (int i = word.length()-1; i>=0; i--){
            result += word.charAt(i);
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(reverse("Chevrolet"));
        System.out.println(reverse("Apple"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your word to reverse: ");
        String userInput = scanner.nextLine();

        StringBuilder reversed = new StringBuilder();
        reversed.append(userInput);
        reversed.reverse();
        System.out.println("Reversed version: " + reversed);

        scanner.close();

    }

}
