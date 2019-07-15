package Concurrency;

public class Test4 extends Thread {

    public static void main(String[] args) {
        Test4 t = new Test4();
        Thread x = new Thread(t);
        x.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "..");

        }
    }

}
