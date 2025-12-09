package javaprogrammingchallengespdf;

import java.util.Scanner;

public class Code05 {

    /*
        Write a program to count the number of
        occurrences of each character in a string?
            Ex: apple
            Output: a-1 p-2 l-1 e-1
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String userInput = scan.nextLine();

        System.out.println(countOccurrenceOfChar(userInput));

        scan.close();

    }

    private static String countOccurrenceOfChar(String str) {
        String result = "";
        char[] arr = new char[str.length()];
        int c = 0;

        for(int i = 0; i < str.length(); i++) {
            int count = 1;

            if(str.charAt(i) != ' ') {

                for(int j = i+1; j<str.length(); j++) {

                    if(str.charAt(i) == str.charAt(j) && i != j) {
                        count++;
                    }

                }

                if(count == 1) {
                    arr[c++] = str.charAt(i);
                }

            }
        }

        for(int i = 0 ; i<arr.length; i++) {
            int count2 = 0;

            if((arr[i]>='a' && arr[i]<='z') || (arr[i]>='A' && arr[i]<='Z')) {

                for(int j=0;j<str.length();j++) {

                    if(arr[i]==str.charAt(j)) {
                        count2++;
                    }

                }

                result += arr[i] + " : " + count2 + " || ";

            }

        }

        return result;

    }

}
