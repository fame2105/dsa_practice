package mutithreading.questions;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

public class ThreadSafeDeferredCallback {

    public static class Callback {
        private long executeAt;
        private String message;

        public Callback(long executeAfter, String message) {
            this.executeAt = System.currentTimeMillis() + executeAfter;
            this.message = message;
        }
    }

    private PriorityQueue<Callback> pq;

    public ThreadSafeDeferredCallback() {
        this.pq = new PriorityQueue<>(new Comparator<Callback>() {
            @Override
            public int compare(Callback c1, Callback c2) {
                return Long.compare(c1.executeAt, c2.executeAt);
            }
        });
    }

    public synchronized void registerCallback(Callback callback) {
        pq.add(callback);
        notify();
    }

    public synchronized void start() throws InterruptedException {
        while (true) {
            while (pq.size() == 0) {
                wait();
            }

            while (pq.size() > 0) {
                long sleepFor = calculateSleepingTime();
                if (sleepFor <= 0) {
                    break;
                }

                wait(calculateSleepingTime()); // keep on sleeping for the due time of the nearest callback
            }

            Callback callback = pq.remove();
            System.out.println(
                    "Executed at " + System.currentTimeMillis() / 1000 + " required at " + callback.executeAt/1000 + ": message:" + callback.message);
        }
    }

    private long calculateSleepingTime() {
        long currentTime = System.currentTimeMillis();
        return pq.peek().executeAt - currentTime;
    }
}

class ThreadSafeDeferredCallback_Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeDeferredCallback service = new ThreadSafeDeferredCallback();
        Thread deferredCallbackThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    service.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        deferredCallbackThread.start();

        Thread shouldBeExecutedInBetweenAllThreads = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSafeDeferredCallback.Callback callback = new ThreadSafeDeferredCallback.Callback(4000, "Hello this is " + Thread.currentThread().getName() + " Random callback in between - ");
                service.registerCallback(callback);
            }
        });
        shouldBeExecutedInBetweenAllThreads.setName("Random CurveBall Callback");
        shouldBeExecutedInBetweenAllThreads.start();

        Random random = new Random();

        HashSet<Thread> allThread = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    int executeAt = random.nextInt(10) + 1;
                    ThreadSafeDeferredCallback.Callback callback = new ThreadSafeDeferredCallback.Callback(executeAt * 1000, "Hello this is " + Thread.currentThread().getName() + " Registering callback - ");
                    service.registerCallback(callback);
                }
            });
            t.setName("Thread" + i);
            t.start();
            allThread.add(t);
            Thread.sleep(500);
        }

        for(Thread thread : allThread) {
            thread.join();
        }
        shouldBeExecutedInBetweenAllThreads.join();
    }
}
