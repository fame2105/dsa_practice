package mutithreading.multithreadingAndParallelComputing;

public class _1_StartingThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        t2.start();
        t1.start();
    }

    private static class Runner1 implements Runnable {

        @Override
        public void run() {
            Thread.currentThread().setName("Runner-1");
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Runner2 implements Runnable {

        @Override
        public void run() {
            Thread.currentThread().setName("Runner-2");
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

