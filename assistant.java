package done;

import java.util.Scanner;

public class assistant{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        greet("Mate", 2019);
        remindName();
        guessAge();
        count();
        test();
        end();

    }


    static void greet(String assistantName, int birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }


    static void remindName() {
        String userName = sc.nextLine();
        System.out.println("What a great name you have, " + userName + "!");
    }


    static void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int r3Age = sc.nextInt();
        int r5Age = sc.nextInt();
        int r7Age = sc.nextInt();
        int age = ((r3Age % 3) * 70 + (r5Age % 5) * 21 + (r7Age % 7) * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }


    static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int number = sc.nextInt();
        for (int i = 0; i <= number; i++) {
            System.out.println(i + "!");
        }
    }

    static void test() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");
        String ans = sc.next();
        while (!"2".equals(ans)) {
            System.out.println("Please, try again.");
            ans = sc.next();
        }

    }


    static void end() {
        System.out.println("Congratulations, have a nice day!");
    }

}