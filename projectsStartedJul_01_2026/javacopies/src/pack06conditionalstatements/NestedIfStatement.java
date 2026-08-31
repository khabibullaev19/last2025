package pack06conditionalstatements;

import java.util.Scanner;

public class NestedIfStatement {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter your gender: ");
        String gender = scan.nextLine();

        System.out.print("Enter your job: ");
        String job = scan.nextLine();

        if (!(age < 0) && (age < 18)) {

            if (gender.equalsIgnoreCase("male")){
                System.out.println("You are a boy!");
            }else if (gender.equalsIgnoreCase("female")){
                System.out.println("You are a girl!");
            }else {
                System.out.println("Enter a valid gender!!!");
            }

        }else if (age >= 18 && age < 100){

            if (gender.equalsIgnoreCase("male")){
                System.out.println("You are a man!");
            }else if(gender.equalsIgnoreCase("female")){
                System.out.println("You are a woman!");
            }else  {
                System.out.println("Enter a valid gender!!!");
            }

        } else if (age > 100) {
            System.out.println("You must be dead😵");
        }

    }

}
