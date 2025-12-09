package javaprogrammingchallengespdf;

import java.util.Scanner;

public class Code03 {

    /*
        Write a program to print last non-repeated
        character from given String?
            Ex: Software Services
            Output: c
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String userInput = scanner.nextLine();

        System.out.println(lastNonRepeatingNumber(userInput));

        scanner.close();

    }

    private static String lastNonRepeatingNumber(String str) {

        String result = "";

        for (int i = str.length()-1; i > 0; i--){
            int count = 0;

            if (str.charAt(i) != ' ') {

                for (int j = 0; j < str.length(); j++){

                    if (str.charAt(i) == str.charAt(j) && i != j){
                        count++;
                        break;
                    }

                }

                if (count == 0) {
                    result += str.charAt(i);
                    break;
                }

            }

        }
        return result;

    }

}
