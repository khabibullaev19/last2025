package javaprogrammingchallengespdf;

import java.util.Scanner;

public class Code04 {

    /*
        Write a program to remove the duplicate
        characters from the given String?
            Ex: banaans
            Output: bans
     */

    private static String removeDuplicate(String str){

        String result = "";

        for (int i = 0; i < str.length(); i++){
            int count = 0;

            if (str.charAt(i) != ' '){

                for (int j = i+1; j < str.length(); j++){

                    if (str.charAt(i) == str.charAt(j) && (i != j)){
                        count++;
                    }

                }

                if (count == 0) {
                    result += str.charAt(i);
                }

            }

        }
        return result;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String userInput = scan.nextLine();

        System.out.println(removeDuplicate(userInput));
        scan.close();

    }

}
