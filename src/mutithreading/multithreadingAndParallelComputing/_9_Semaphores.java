package mutithreading.multithreadingAndParallelComputing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 * Maintains a set of permits and has 2 important functions
 * acquire() -> is a permit is available then takes it
 * release() -> adds a permit
 *
 * Semaphore keeps a count of the number of available permits
 * new Semaphore(int permits)
 * new Semaphore(int permits, boolean fair)
 */

enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true); // less than or equal to 3 threads would be allowed to acquire permits at one time, in this case

    public void downloadData(int task) {
        try {
            semaphore.acquire();
            download(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void download(int task) {
        System.out.println("Downloading data from the web ... " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download Completed... " + task);
    }
}

public class _9_Semaphores {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 12; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.downloadData(finalI);
                }
            });
        }
    }
}
