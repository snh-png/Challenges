package Concurrency;


import java.util.concurrent.*;

//let's dive into an example and see how callable and future objects work in tandem
public class Demo1 {
    //Create and initialize a threadpool
    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("sum: " +findSum(10));
        threadPool.shutdown();
    }

    static int findSum(final int n) throws ExecutionException, InterruptedException {
        Callable<Integer> sumTask = () -> {
            int sum = 0;
            for (int i = 1; i <= n; i++)
                sum += 1;
            return sum;
        };
        Future<Integer> f = threadPool.submit(sumTask);
        return f.get();
    }

}
