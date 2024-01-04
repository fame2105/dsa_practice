package mutithreading.questions;

public class CountingSemaphore {
    int usedPermits = 0;
    int maxCount;

    public CountingSemaphore(int count) {
        this.maxCount = count;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxCount) {
            wait();
        }

        Thread.sleep(1000);
        notify();
        usedPermits++;
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            wait();
        }

        Thread.sleep(1000);
        usedPermits--;
        notify();
    }
}

class Demonstration {
    public static void main(String args[]) throws InterruptedException {
        final CountingSemaphore cs = new CountingSemaphore(1);

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        cs.acquire();
                        System.out.println("Ping " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        cs.release();
                        System.out.println("Pong " + i);
                    } catch (InterruptedException ie) {
                    }
                }
            }
        });
        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}

