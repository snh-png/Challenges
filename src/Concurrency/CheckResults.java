package Concurrency;

import java.util.concurrent.*;

public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<?> result = executorService.submit(() -> {
                for (int i = 0; i < 10000; i++) {
                    counter++;
                }
                return counter;
            });
            System.out.println(result.get(10, TimeUnit.NANOSECONDS));
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }
}
