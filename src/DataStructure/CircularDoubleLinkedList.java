package DataStructure;

import java.util.Scanner;

class CircularDoubleLinkedList {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int inputSize = s.nextInt();
        Integer firstNumber = null;
        int currentIndex = 1;
        StringBuilder op = new StringBuilder();

        while (currentIndex <= inputSize) {
            int currentNumber = s.nextInt();
            if (firstNumber == null) firstNumber = currentNumber;
            if (currentIndex > 1 && firstNumber == currentNumber) break;
            if (currentIndex <= 3 || currentIndex % 3 == 0)
                op.append(currentNumber + " ");
            currentIndex++;
        }

        System.out.println(op);
    }
}
