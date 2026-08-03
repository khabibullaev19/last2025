package pack03variables;

import org.w3c.dom.ls.LSOutput;

public class TypeCasting {

    /*

        - byte < short < int < long < float < double

        📌Casting allows us to assign one primitive type value
          to another type value.

        -> There are two types of type casting:
           - Auto widening(Implicit type casting) = small to large
           - Explicit Narrowing. = large to small

        📌Auto widening( Implicit type casting ):
          Converting small data type to the larger one.
          Converting small to large is easy, because of that, Java
          can do it easily.

        📌Explicit Narrowing:
          Converting larger data type value to the smaller one.
          It is done manually!🕹️

     */

    public static void main(String[] args) {

        // Implicit casting -> small to large:
        byte age1 = 24;
        int age2 = age1;
        System.out.println("byte to int: " + age2);

        int speed1 = 156;
        long speed2 = speed1;
        System.out.println("int to long: " + speed2);

        float price1 = 12.5f;
        double price2 = price1;
        System.out.println("float to double: " + price2);

        // Explicit narrowing -> large to small:
        int count1 = 10;
        byte count2 = (byte)count1;
        System.out.println("int to byte: " + count2);

        long number1 = 2342342;
        int number2 = (int)number1;
        System.out.println("long to int: " + number2);

    }

}
