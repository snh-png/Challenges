package DataStructure;

import java.util.Scanner;

public class Bomber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine());
        test(input);
        System.out.println("Result: " + input);
    }

    private static void test(StringBuilder input) {
        int count = 0;
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char lastChar = input.charAt(i - 1);
            if (currentChar == lastChar)
                count++;
            else if (count >= 2 && lastChar != currentChar) {
                input.replace(i - 1 - count, i, "");
                test(input);
            } else {
                count = 0;
            }
        }
    }
}