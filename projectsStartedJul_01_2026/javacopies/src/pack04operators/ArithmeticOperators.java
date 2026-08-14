package pack04operators;

public class ArithmeticOperators {

    /*

        - Arithmetic Operators:
          1. " + " => Addition -> Adds two numbers.
          2. " - " => Subtraction -> Subtracts one number from another number.
          3. " * " => Multiplication -> Multiplies two numbers.
          4. " / " => Division -> Divides one number by another number.
          5. " % " => Modulus -> Divides and returns the remainder of two numbers.

     */

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println(a + b * 2);//50
        System.out.println((a + b) * 2);//60

        System.out.println((a + b) / 2);//15
        System.out.println(a + b / 2);//20

        System.out.println((a + 11 + 2) % 2);//1

    }

}
