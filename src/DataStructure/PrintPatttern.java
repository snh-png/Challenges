package DataStructure;

import java.util.Scanner;

public class PrintPatttern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[] inputArr = new int[testCases];
        for (int i = 0; i < testCases; i++) {
            inputArr[i] = sc.nextInt();
        }

        for (int input : inputArr) {
            int size = input * 2 - 1;
            int[][] pattern = new int[size][size];
            for (int i = 0; i < size; i++) {
                pattern[0][i] = input;
            }
            for (int i = 1; i <= size / 2; i++) {
                for (int j = 0; j < size; j++) {
                    if (j >= i && j < size - i) {
                        pattern[i][j] = input - i;
                    } else pattern[i][j] = pattern[i - 1][j];
                }
            }

            for (int i = 0; i < input; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(pattern[i][j] + " ");
                }
                System.out.println();
            }

            for (int i = size / 2 - 1; i >= 0; i--) {
                for (int j = 0; j < size; j++) {
                    System.out.print(pattern[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}
