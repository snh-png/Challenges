package Concurrency;

public class Test implements Runnable {
    Integer id = 1;

    public static void main(String[] args) {
        new Thread(new Test()).start();
        new Thread(new Test()).start();
        new Thread(new Test()).start();
    }

    @Override
    public void run() {
        press(id);
    }

    synchronized void press(Integer id) {
        System.out.print(id.intValue());
        System.out.print((++id).intValue());
    }
}
