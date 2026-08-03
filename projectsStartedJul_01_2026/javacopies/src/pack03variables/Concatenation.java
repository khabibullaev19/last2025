package pack03variables;

public class Concatenation {

    /*

        - The action of linking Strings(or others too) together by using "+" operator.
        - There must be a String of text on the right or left side of the "+" operator.

     */

    public static void main(String[] args) {

        String firstName = "Muhammad Ali";
        String lastName = "Xabibullayev";
        int age = 24;

        System.out.println(firstName + age);
        System.out.println(firstName + 2 + 4);
        System.out.println(age + firstName);
        System.out.println(2 + 4 + firstName);//6
        System.out.println((2 + 4) + firstName);
        System.out.println(firstName + (2 + 4));

    }

}
