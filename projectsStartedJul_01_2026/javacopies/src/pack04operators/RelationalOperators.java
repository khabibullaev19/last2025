package pack04operators;

public class RelationalOperators {

    /*

            - Relational Operators:
            1. " < " => Less Than -> If the value of the first operand is lesser than
            the value of the second operand, the Less Than operator returns true, otherwise false.

            2. " > " => Greater Than -> If the value of the first operand is greater than
            the value of the second operand, the Greater than operator returns true, otherwise false.

            3. " <= " => Less Than or Equal To -> When the value of the first operand is lesser
            than or equal to the value of the second operand, the Less Than or Equal To operator
            returns true, otherwise false.

            4. " >= " => Greater Than or Equal To -> When the value of the first operand is greater than
            or equal to the value of the first operand, the Greater Than or Equal To operator returns
            true, otherwise false.

            5. " == " => Equal To -> Equal To operator checks whether the given operands are equal or not.
            If they are equal, they return true, otherwise false.

            6. " != " => Not Equal To -> Not Equal to operator works just opposite to Equal to operator. It returns
            false if the operands are equal in value, otherwise true.

     */

    public static void main(String[] args) {

        int num1 = 2;
        int num2 = 10;
        int num3 = 12;

        System.out.println(num1 + num2 == num3);//true
        System.out.println(num1 + num2 != num3);//false
        System.out.println(num1 + num2 <= num3);//true
        System.out.println(num1 + num2 >= num3);//true

        System.out.println('a' == 'A');//false
        System.out.println('a' != 'a');//false
        System.out.println(true != false);//false

    }

}
