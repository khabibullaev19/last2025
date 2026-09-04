package pack08wrapperclassesscope;

public class WrapperClasses {

    /*

        In Java, wrapper classes allow primitive data types to be represented as objects.
        This enables primitives to be used in object-oriented features such as collections,
        generics, and APIs that require objects.

        - Each wrapper class encapsulates a corresponding primitive value inside an object
          (e.g., Integer for int, Double for double).

        - Java provides wrapper classes for all eight primitive
          data types to support object-based operations.


        -> Wrapper Classes: give the object representation of each primitive
            byte -> Byte
            short -> Short
            int -> Integer
            long -> Long
            float -> Float
            double -> Double
            char -> Character
            boolean -> Boolean

            Why they exist:
            1. Collections need objects, List<int> is illegal - generics only work with objects.
               We must use List<Integer>.
            2. Null Representation, a primitive "int" can never be "null", "Integer" can. This
               matters a lot in backend work, e.g. a DataBase column that's nullable should be
               mapped to "Integer", not "int".
            3. Utility Methods. Wrapper classes carry useful static methods: Integer.parseInt("42"),
               Integer.MAX_VALUE, Character.isDigit(c), etc.

     */

    public static void main(String[] args) {

        String number1 = "123";
        int number2 = 1234;
        double number4 = 34.32;

        //Integer.parseInt(String) gives back "int"
        int number3 = Integer.parseInt(number1);
        System.out.println(number3);
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt(number1));
        System.out.println(Double.parseDouble(number1));
        System.out.println(Float.parseFloat(number1));
        System.out.println(Byte.parseByte(number1));

        //Integer.valueOf(String/int) gives back Integer object (NOT PRIMITIVE)
        System.out.println(Integer.valueOf(number2));

    }

}
