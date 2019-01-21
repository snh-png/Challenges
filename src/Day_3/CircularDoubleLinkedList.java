package Day_3;

import java.util.Scanner;

class CircularDoubleLinkedList {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int inputSize = s.nextInt();
        int[] input = new int[inputSize];

        int counter = 0;
        while (counter < inputSize) {
            input[counter] = s.nextInt();
            counter++;
        }

        int i = 0;
        int multipleOfThree = 1;
        StringBuilder op = new StringBuilder();
        while (i < inputSize) {
            int currentNumber = input[i];
            if (i > 0 && input[0] == currentNumber) break;
            op.append(currentNumber + " ");
            if (i >= 2) {
                multipleOfThree++;
                i = 3 * multipleOfThree - 1;
            } else i++;
        }
        System.out.println(op);
    }
}
