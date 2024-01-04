package mutithreading.multithreadingAndParallelComputing;

public class _2_StartingThreads {
    public static void main(String[] args) {
        Runner1 t1 = new Runner1();
        Runner2 t2 = new Runner2();

        t1.start();
        t2.start();
    }

    private static class Runner1 extends Thread {

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

    private static class Runner2 extends Thread {

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
