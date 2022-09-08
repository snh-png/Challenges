package StarProblems;

import java.util.stream.IntStream;

public class StarSquare {

    public static void main(String[] args) {
        int row = 3;
        int col = 5;

        IntStream.range(0, row).forEach(i -> {
                    for (int j = 0; j < col; j++) {
                        if (i == 0 || i == row - 1) {
                            System.out.print("*");
                        } else {
                            if (j == 0 || j == col - 1)
                                System.out.print("*");
                            else System.out.print(" ");
                        }
                    }
                    System.out.println("");
                }
        );
    }
}
