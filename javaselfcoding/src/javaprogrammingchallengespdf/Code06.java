package javaprogrammingchallengespdf;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Code06 {

    /*
        Write a program to print duplicate characters
        from the given String?
            Ex: Programming
            Output: r, g, m
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String userInput = scan.nextLine();

        System.out.println(printDuplicateChars(userInput));

    }

    private static Set<Character> printDuplicateChars(String str){

        Set<Character> result = new HashSet<>();

        for (int i = 0; i < str.length(); i++){

            int count = 0;

            if (str.charAt(i) != ' ') {

                for (int j = 0; j < str.length(); j++) {

                    if (str.charAt(i) == str.charAt(j) && (i != j)){

                        result.add(str.charAt(i));

                    }

                }

            }

        }

        return result;

    }

}
