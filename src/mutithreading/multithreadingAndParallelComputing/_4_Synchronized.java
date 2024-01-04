package mutithreading.multithreadingAndParallelComputing;

public class _4_Synchronized {
    public static void main(String[] args) {
        process();
        System.out.println(counter);
    }

    static int counter = 0; // counter is shared variable which is being read by multiple threads

    private static synchronized void increment() {
        counter++;
    }

    private static void process() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


