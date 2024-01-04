package mutithreading.multithreadingAndParallelComputing;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A CyclicBarrier is a synchronizer that allows a set of threads to wait for each other to reach a common execution point, also called a barrier.
 * CyclicBarriers are used in programs in which we have a fixed number of threads that must wait for each other to reach a common point before continuing execution.
 *
 * public CyclicBarrier(int parties, Runnable barrierAction)   // barrier action gets called when the barrier is tripped.
 *
 * In Cyclic Barrier, the thread calling new CyclicBarrier().await() is suspended until all the other threads have arrived at the barrier
 *
 */
public class _12_CyclicBarrier {

    private static class Worker implements Runnable {
        private int id;
        private CyclicBarrier cyclicBarrier;

        public Worker(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Worker " + id + " is processing...");
            doWork();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(2000);
                System.out.println("Worker " + id + " task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class AggregatorThread implements Runnable { // this thread gets called when the barrier is tripped by the last thread that calls await()

        @Override
        public void run() {
            System.out.println("All tasks finished");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new AggregatorThread());

        for(int i = 1; i <= 5; i++) {
            executorService.execute(new Worker(i, cyclicBarrier));
        }

        executorService.shutdown();
    }
}
