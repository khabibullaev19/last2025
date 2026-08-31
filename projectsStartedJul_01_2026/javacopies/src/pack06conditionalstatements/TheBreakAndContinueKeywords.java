package pack06conditionalstatements;

public class TheBreakAndContinueKeywords {

    /*

        - Break: You have already seen the "break" statement used in an earlier chapter,
                 it was used to "jump out" if a "switch" statement.

                 The "break" statement can also be used to jump out of a "loop".

        - Continue: statement breaks one iteration(in the loop), if a specified condition occurs,
                    and continues with the next iteration in the loop.

     */

    public static void main(String[] args) {

        // break usage:
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // continue usage:
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.print(i + " ");
        }

    }

}
