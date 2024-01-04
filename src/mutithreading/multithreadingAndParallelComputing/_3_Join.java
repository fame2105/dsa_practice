package mutithreading.multithreadingAndParallelComputing;

public class _3_Join {
    public static void main(String[] args) {
        Runner1 t1 = new Runner1();
        Runner2 t2 = new Runner2();

        t1.start();
        t2.start();

        try {
            t1.join(); // execution of main thread will be suspended till t1 has completed its tasks

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Runner-1 Tasks finished");

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
            for (int i = 1; i <=  30; i++) {
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
