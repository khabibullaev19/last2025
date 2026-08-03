package pack03variables;

public class Increment {

    // Increment: To increase the value of a variable.

    public static void main(String[] args) {

        int num1 = 1;

        //1. Way
        num1 = num1 + 5;
        System.out.println(num1);

        //2. Way
        num1+=3;
        System.out.println(num1);

        //3. Way
        num1++;
        System.out.println(num1);

        // ----------------------
        num1 = num1 * 2;
        System.out.println(num1);

        num1*=2;
        System.out.println(num1);

    }

}
