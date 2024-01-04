package mutithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {

    private static final int NO_OF_THREADS = 2;

    /**
     * Callable interface is useful when we want to return something from our thread,
     * As opposed to Runnable interface that doesn't returns anything after the thread has finished execution.
     */
    private static class Processor implements Callable<String> {

        private int id;

        public Processor(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            System.out.println("Executing in Thread :" + Thread.currentThread().getName() + " Working for Process having ID: " + this.id);
            Thread.sleep(1000);
            return "ID : " + this.id;
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            futureList.add(executorService.submit(new Processor(i)));
        }

        for (Future<String> future : futureList) {
            try {
                System.out.println(future.get()); // note: future.get() is a blocking call, this blocks the calling thread, in this case, [main] thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

    }
}
