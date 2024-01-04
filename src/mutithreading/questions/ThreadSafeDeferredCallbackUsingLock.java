package mutithreading.questions;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeDeferredCallbackUsingLock {
    static class Callback {
        private long executeAt;
        private String message;

        public Callback(long executeAfter, String message) {
            this.executeAt = System.currentTimeMillis() + executeAfter;
            this.message = message;
        }
    }

    private PriorityQueue<Callback> pq;
    private ReentrantLock lock = new ReentrantLock();
    private Condition newCallBackArrived = lock.newCondition();

    public ThreadSafeDeferredCallbackUsingLock() {
        this.pq = new PriorityQueue<>(new Comparator<Callback>() {
            @Override
            public int compare(Callback c1, Callback c2) {
                return Long.compare(c1.executeAt, c2.executeAt);
            }
        });
    }

    public void registerCallback(Callback callback) {
        lock.lock();
        pq.add(callback);
        newCallBackArrived.signal();
        lock.unlock();
    }

    public void start() throws InterruptedException {
        while (true) {
            lock.lock();
            while (pq.size() == 0) {
                newCallBackArrived.await();
            }

            while (pq.size() > 0) {
                long sleepFor = calculateSleepingTime();
                if (sleepFor <= 0) {
                    break;
                }

                newCallBackArrived.await(calculateSleepingTime(), TimeUnit.MILLISECONDS); // keep on sleeping for the due time of the nearest callback
            }

            Callback callback = pq.remove();
            System.out.println(
                    "Executed at " + System.currentTimeMillis() / 1000 + " required at " + callback.executeAt/1000 + ": message:" + callback.message);
            lock.unlock();
        }
    }

    private long calculateSleepingTime() {
        long currentTime = System.currentTimeMillis();
        return pq.peek().executeAt - currentTime;
    }
}

class ThreadSafeDeferredCallbackUsingLockMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeDeferredCallbackUsingLock service = new ThreadSafeDeferredCallbackUsingLock();
        Thread deferredCallbackUsingLockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    service.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        deferredCallbackUsingLockThread.start();

        Thread shouldBeExecutedInBetweenAllThreads = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSafeDeferredCallbackUsingLock.Callback callback = new ThreadSafeDeferredCallbackUsingLock.Callback(4000, "Hello this is " + Thread.currentThread().getName() + " Random callback in between - ");
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
                    ThreadSafeDeferredCallbackUsingLock.Callback callback = new ThreadSafeDeferredCallbackUsingLock.Callback(executeAt * 1000, "Hello this is " + Thread.currentThread().getName() + " Registering callback - ");
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
