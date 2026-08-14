package pack04operators;

public class UnaryOperators {

    /*

        Unary Operators:
        1. " + " => Unary Plus Operator -> Indicates positive value.
        2. " - " => Unary Minus Operator -> Negates an expression or value.
        3. " ++ " => Increment Operator -> Increments a value by 1.
        4. " -- " => Decrement Operator -> Decrements a value by 1.
        5. " ! " => Logical Complement Operator -> The Not operator is used to convert a boolean value.

            Pre-Increment & Pre-Decrement
        -> Increment/Decrement operators are placed BEFORE the operand.
        -> Increase/Decrease the value by 1 in the memory.

     */

    public static void main(String[] args) {

        int x = 10;

        System.out.println(x++);//10 --> In POST-increment, the value of the operand is used first,
                                //       then its value is increased by one.
        System.out.println(++x);//12

        System.out.println(x--);//12
        System.out.println(--x);//10

        int y = 15;
        boolean d = true;
        System.out.println(!d);//false

    }

}
