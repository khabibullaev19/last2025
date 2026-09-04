package pack09loops;

public class NestedForLoop {

    public static void main(String[] args) {

        int column = 0;
        int row = 0;
        System.out.println("Column: " + column);
        System.out.println("Raw: " + row);
        System.out.println();

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 6; j++) {
                column = j;
                System.out.print(j + " ");
            }
            row++;
            System.out.println();

        }

        System.out.println();
        System.out.println("Column: " + column);
        System.out.println("Raw: " + row);

    }

}
