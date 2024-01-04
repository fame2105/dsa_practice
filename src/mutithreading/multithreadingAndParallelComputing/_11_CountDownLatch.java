package mutithreading.multithreadingAndParallelComputing;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _11_CountDownLatch {

    private static class Worker implements Runnable {

        private int id;
        private CountDownLatch latch;

        public Worker(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Worker " + id + " is executing");
            try {
                doWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown(); // current thread is signalling that it has completed its assigned task, doing so will decrement the countdown in the passed in latch
        }

        private void doWork() throws InterruptedException {
            Thread.sleep(2000);
            System.out.println("Worker " + id + " task Completed");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            executorService.execute(new Worker(i, latch));
        }

        try {
            latch.await(); // calling thread(main thread in this case), will be blocked/waiting until the countdown of the latch becomes zero.
            // latch.await(3l, TimeUnit.SECONDS); // ... calling thread will wait only 3 seconds and then it will execute
            System.out.println("All worker tasks are completed...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
