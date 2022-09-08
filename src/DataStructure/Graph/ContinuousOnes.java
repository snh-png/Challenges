package DataStructure.Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class ContinuousOnes {
    public static void main(String[] args) {
        int row = 5;
        int column = 9;
        int[][] input = new int[row][column];
        input[0] = new int[] {1, 1, 0, 0, 0, 1, 1, 1, 1};
        input[1] = new int[] {0, 1, 1, 0, 0, 1, 0, 0, 0};
        input[2] = new int[] {0, 0, 1, 1, 1, 1, 0, 0, 0};
        input[3] = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
        input[4] = new int[] {0, 0, 0, 0, 0, 1, 0, 0, 0};

//        new Scanner(System.in)

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }

        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (input[i][j] == 1)
                    findPath(input, i, j, result, row, column);
            }
        }

        result.stream().forEach(el -> System.out.print(el + " "));
    }

    private static void findPath(int[][] input, int rowIndex, int colIndex, LinkedList<Integer> path, int rowSize, int colSize) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= rowSize || colIndex >= colSize) return;
        int data = input[rowIndex][colIndex];
        if (data == 1) {
            path.add((colSize * rowIndex) + colIndex + 1);
            //add the index to path
            //and mark the data to visited
            input[rowIndex][colIndex] = 2;
        } else return;

        findPath(input, rowIndex + 1, colIndex, path, rowSize, colSize);
        findPath(input, rowIndex - 1, colIndex, path, rowSize, colSize);
        findPath(input, rowIndex, colIndex + 1, path, rowSize, colSize);
        findPath(input, rowIndex, colIndex - 1, path, rowSize, colSize);
    }
}
