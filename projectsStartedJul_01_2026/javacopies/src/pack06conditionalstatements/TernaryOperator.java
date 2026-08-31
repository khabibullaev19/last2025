package pack06conditionalstatements;

import java.util.Scanner;

public class TernaryOperator {

    /*

        - Ternary: (condition) ? true : false;

     */

    public static void main(String[] args) {

        String result;
        int age1, age2, age3;

//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter you age: ");
//        age = scan.nextInt();
//        scan.nextLine();
        age1 = 18;
        age2 = 17;
        age3 = 20;

        //1. with if statement:
        if (age1 >= 18){
            result = "You are a man";
        }else {
            result = "You are a boy";
        }
        System.out.println(result);

        //2. with ternary operator:
        //a:
        result = age2 >= 18 ? "You are a man" : "You are a boy";
        System.out.println(result);

        //b:
        System.out.println(age3 >= 18 ? "You are a man" : "You are a boy");

    }

}
