package mutithreading.multithreadingAndParallelComputing;

import java.util.concurrent.locks.ReentrantLock;

public class _8_ReentrantLock {

    private static int counter = 0;
    /**
     * When using Reentrant locks, it becomes necessary to unlock/release the lock inside a finally block,
     * because if the snippet inside critical section throws any errors then
     * lock won't be released and all the other threads would be starved
     * Reasons for Using Lock :
     *  1. A lock could be made fair, i.e we could prevent thread starvation by initializing locks like new ReentrantLock(true).
     *  2. Locks provide a functionality whereby we could check if a lock is held or not by using ReentrantLock
     *  3. We can also get the list of threads waiting to get a lock by using ReentrantLock
     *
     * Reasons for Not Using Lock:
     *  1. A lock could be locked at one part of the code and unlocked in another, this has a potential for creating more problems thatn it would solve
     *  2. try-catch-finally block is a necessity when using locks.
     */
    private static final ReentrantLock lock = new ReentrantLock();

    private static void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);
    }
}