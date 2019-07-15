package Concurrency;

public class Test13 {
    public static void main(String[] args) {
        Test13 he = new Test13();
        he.output();
    }

    void output() {
        long[] x = {7,8,9};
        System.out.println(x[0] + x[1] + x[2] + " ");
        long[] y = fix(x);
        System.out.println(x[0] + x[1] + x[2] + " ");
        System.out.println(y[0] +y[1] + y[2]);
    }

    private long[] fix(long[] z) {
        z[1] = 4;
        return z;
    }
}
