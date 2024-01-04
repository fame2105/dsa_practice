package mutithreading.multithreadingAndParallelComputing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable can return a value wrapped in a Future whereas run method in Runnable can't return value
 */
public class _10_CallableAndFutures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Future<String> future = executorService.submit(new Compute(i));
            futures.add(future);
        }

        for (Future<String> result : futures) {
            String str = result.get(); // Future.get() method blocks until the task is completed... it is a blocking call
            System.out.println(str);


        }

        executorService.shutdown();
    }
}

class Compute implements Callable<String> {

    private int id;

    public Compute(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return String.format("id : %d", id);
    }
}
