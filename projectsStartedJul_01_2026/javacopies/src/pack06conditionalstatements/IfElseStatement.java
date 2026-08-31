package pack06conditionalstatements;

public class IfElseStatement {

    public static void main(String[] args) {

        int age = 24;
        boolean isStudent = true;

        if (isStudent && age >= 18) {
            System.out.println("Allowed to work");
        }else  {
            System.out.println("Not allowed to work");
        }

    }

}
