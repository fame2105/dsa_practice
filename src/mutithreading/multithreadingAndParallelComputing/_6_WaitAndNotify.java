package mutithreading.multithreadingAndParallelComputing;

class Processor {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("1. Inside Producer Method"); // 1st output
            wait(); // instantly gives up the lock and thread will continue execution from this point when it gains the lock again
            System.out.println("4. Got the lock, again inside producer method"); // 4th output
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (this) {
            System.out.println("2. Inside Consumer Method"); // 2nd Output
            notify(); // gives up the lock but after completing/exiting synchronized block
            System.out.println("3. I am the boss"); // 3rd output
        }
    }
}

public class _6_WaitAndNotify {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
    }
}
