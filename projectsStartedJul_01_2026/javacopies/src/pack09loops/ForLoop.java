package pack09loops;

public class ForLoop {

    /*

        -

     */

    public static void main(String[] args) {

        // for loop:
        //When you know the exact number of iterations in advance - counting,
        //indexing arrays, fixed repetitions:
        for (int i = 0; i < 5; i++) {
            System.out.println("Running 5 times.");
        }

        for (int i = 5; i > 0 ; i--) {
            System.out.println("RUNNING 5 times.");
        }

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers until 10: " + sum);

        int multiplication = 1;
        for (int i = 1; i <= 5; i++) {
            multiplication *= i;
        }
        System.out.println("Multiplication of numbers until 5: " + multiplication);

    }

}
