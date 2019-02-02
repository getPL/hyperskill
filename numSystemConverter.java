package done;

import java.util.Scanner;
class numSystemConverter {

    private static boolean isDouble(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '.') {
                return true;
            }
        }

        return false;
    }


    private static String numberToSingleNS(String number, int source) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(number, source); i++) {
            sb.append("1");
        }
        return sb.toString();
    }


    private static double fractionalToDecimal(int source, String fracPart) {
        double answer = 0;
        for (int i = 0; i < fracPart.length(); i++) {
            answer += (double)Character.digit(fracPart.charAt(i), source) / Math.pow(source, i+1);
        }
        return answer;
    }


    private static String decimalFractionToTarget(double fraction, int target) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            fraction *= target;
            sb.append(Integer.toString((int)fraction, target));
            fraction -= (int)fraction;
        }
        return sb.toString();
    }


    private static String numberFromTo(int source, String number, int target) {

        if (source < 1 || source > 36 || target < 1 || target > 36) {
            throw new ArithmeticException("Radix error");
        }

        if (isDouble(number)) {
            String[] intAndFrac = number.split("\\."); // [0] - integer part; [1] - fractional part;
            // mistake with array // done
            long integerPart = source != 1 ? Long.parseLong(intAndFrac[0], source) : number.length();
            double fractionalPart = fractionalToDecimal(source, intAndFrac[1]);
            if (target != 1) {
                return Long.toString(integerPart, target) + "." + decimalFractionToTarget(fractionalPart, target);
            } else {
                return numberToSingleNS(Long.toString(integerPart), source);
            }
        } else {
            long decimalNumber = source != 1 ? Long.parseLong(number, source) : number.length();
            return target != 1 ? Long.toString(decimalNumber, target) : numberToSingleNS(number, source);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int source;
        String number;
        int target;


        // reading input
        try {
            source = sc.nextInt();
            number = sc.next();
            target = sc.nextInt();
            System.out.println(numberFromTo(source, number, target));
        } catch (Exception e) {
            System.out.println("error");
        }

    }
}