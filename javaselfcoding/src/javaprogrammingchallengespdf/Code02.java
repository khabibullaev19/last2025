package javaprogrammingchallengespdf;

public class Code02 {

    /*
        Write a program to print First non-repeated
        character from given String?
            Ex: Software Services
            Output: o
     */

    static String givenString = "cccvssss";

    public static String firstNonRepeatingNumber(String str) {
        String result = "";

        for(int i = 0; i < str.length(); i++) {
            int count = 0;

            if(str.charAt(i) != ' ') {

                for(int j = 0; j < str.length(); j++) {

                    if(str.charAt(i) == str.charAt(j) && i != j) {
                        count++;
                        break;
                    }

                }

                if(count == 0) {
                    result += str.charAt(i);
                    break;
                }

            }

        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println(firstNonRepeatingNumber(givenString));

    }

}
