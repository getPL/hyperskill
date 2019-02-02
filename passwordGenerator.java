package done;

import java.util.*;

public class passwordGenerator {

    private static char upperCase() {
        return (char)(65 + (int)(Math.random() * 26));
    }

    private static char lowerCase() {
        return (char)(97 + (int)(Math.random() * 26));
    }

    private static char digit() {
        return (char)(48 + (int)(Math.random() * 10));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 65 - 90 // 65 + (int)(Math.random() * 26)
        int b = sc.nextInt(); // 97 - 122 // 97 + (int)(Math.random() * 26)
        int c = sc.nextInt(); // 48 - 57 // 48 + (int)(Math.random() * 10)
        int n = sc.nextInt();
        int i;
        int key;
        int ranVal;
        String password = "";

        for (i = 0; i < n; i++) {

            ranVal = (int)(Math.random() * (n - i));
            if (a == 0 && b == 0 & c == 0) {
                key = (int)(Math.random() * 3);
                switch(key) {
                    case 0:
                        password += upperCase();
                        break;
                    case 1:
                        password += lowerCase();
                        break;
                    case 2:
                        password += digit();
                        break;
                }
            } else if (ranVal < a) {
                password += upperCase();
                a--;
            } else if (ranVal < a + b) {
                password += lowerCase();
                b--;
            } else {
                password += digit();
                c--;
            }
        }

        boolean hasMistake = true;
        while (hasMistake) {
            hasMistake = false;
            for (i = 1; i < password.length(); i++) {
                if (password.charAt(i - 1) == password.charAt(i)) {
                    if (Character.isDigit(password.charAt(i))) {
                        password = password.substring(0, i) + digit() + password.substring(i + 1);
                        hasMistake = true;
                    } else if (Character.isUpperCase(password.charAt(i))) {
                        password = password.substring(0, i) + upperCase() + password.substring(i + 1);
                        hasMistake = true;
                    } else {
                        password = password.substring(0, i) + lowerCase() + password.substring(i + 1);
                        hasMistake = true;
                    }

                }
            }
        }

        System.out.print(password);

    }
}