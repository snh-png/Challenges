package Day_10;

public class Pattern {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i + 1; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
