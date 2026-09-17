public class C01Variables {

    /*

        Variable = a reusable container for a value.
                   a variable behaves as if it was the value it contains.

        Primitive = simple value stored directly in memory(stack)
        Reference = memory address (stack) that points to the (heap)

        📌Primitive   vs   📍Reference
            int              String
            double           Array
            char             Object
            boolean

            2 Steps to create a variable.
            1. declaration
            2. assignment
     */

    public static void main(String[] args) {

        int age = 24;
        int year = 2026;
        int quantity = 1;

        double price = 19.99;
        double gpa = 3.5;
        double temperature = -12.5;

        char grade = 'A';
        char symbol = '!';
        char currency = '$';

        boolean isStudent = false;
        boolean isTester = true;
        boolean isOnline = true;

        String name = "Ali";
        String food = "Pizza";
        String email = "fake123@gmail.com";
        String car = "BMW";
        String color = "red";

        System.out.println(food);
        System.out.println(name);
        System.out.println(email);
        System.out.println(car);
        System.out.println(color);

        System.out.println();

        System.out.println(age);
        System.out.println("The year is " + year);
        System.out.println(temperature);
        System.out.println("The currency is " + currency);

        if (isTester == true) {
            System.out.println("He is a tester? " + isTester);
        }

        System.out.println("Hello " + name);

    }

}
