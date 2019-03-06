package DataStructure;

import java.text.DecimalFormat;

public class Fibonacci {
    public static void main(String[] args) {
        int input = 5;
        System.out.println(input + "th number in series: " + fibNth_Number(input));
        fibSeries(input);
    }

    private static int fibNth_Number(int number) {
        if (number < 1) throw new IllegalArgumentException("Input should be greater than 0");
        if (number <= 2) return --number;
        return fibNth_Number(number - 1) + fibNth_Number(number - 2);
    }

    private static void fibSeries(int upto) {
        double counter = 0, t1 = 0, t2 = 0, sum = 0;
        DecimalFormat decimalFormat = new DecimalFormat("");
        System.out.print("Series having " + upto + " numbers: ");
        while (counter < upto) {
            if (counter == 0) {
                t1 = 0;
                System.out.print(decimalFormat.format(t1));
            } else if (counter == 1) {
                t2 = 1;
                System.out.print(decimalFormat.format(t2));
            } else {
                sum = t1 + t2;
                System.out.print(decimalFormat.format(sum));
                t1 = t2;
                t2 = sum;
            }
            counter++;
            System.out.print(" + ");
        }
    }
}
