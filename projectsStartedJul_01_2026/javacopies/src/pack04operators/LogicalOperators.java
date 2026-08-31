package pack04operators;

public class LogicalOperators {

    /*

        - Logical Operators:
        1. " && " => Conditional AND operator -> The logical && operator does not check the
        second condition if the first condition is false. It checks the second condition only
        if the first one is true.

        2. " || " => Conditional OR operator -> The logical || operator does not check the second condition
        if the first condition is true. It checks the second condition only if the first one is false.

        3. " ! " => Bitwise Complement => The NOT operator is used to reverse the value of a Boolean expression.

     */

    public static void main(String[] args) {

        int num1 = 55;
        int num2 = 14;
        int num3 = 20;

        System.out.println(num1 > num2 && num1 < num3);//false
        System.out.println(num1 != num2 && num1 == num3);//false
        System.out.println(num1 < num2 || num2 < num3);//true

    }

}
