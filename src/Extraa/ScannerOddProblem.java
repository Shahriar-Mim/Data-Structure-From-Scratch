package Extraa;

import java.util.Scanner;
/* YT tutorial: https://www.youtube.com/watch?v=bbCr7CE97lU */
public class ScannerOddProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = sc.nextLine();
        System.out.println(name);
        System.out.println("Please enter your age");
        double age = sc.nextInt();
        System.out.println(age);
        System.out.println("Please enter your name2");
        String name2 = sc.nextLine();
        System.out.println(name2);
        System.out.println("Please enter your age2");
        double age2 = sc.nextInt();
        System.out.println(age2);
        System.out.println("Please enter your name3");
        String age3 =sc.nextLine();
        // Consuming the \n
        String consume = sc.nextLine(); 
        System.out.println(age3);
    }
}
