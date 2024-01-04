package mutithreading.multithreadingAndParallelComputing;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue API (interface) is a threadsafe option for using a queue
 * We can distinguish two types of BlockingQueue:
 * unbounded queue – can grow almost indefinitely  ex: BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(); default_capacity : Integer.MAX_VALUE
 * bounded queue – with maximal capacity defined   ex: BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);
 * <p>
 * Methods :
 * Adding Elements
 * add() – returns true if insertion was successful, otherwise throws an IllegalStateException
 * put() – inserts the specified element into a queue, waiting for a free slot if necessary
 * offer() – returns true if insertion was successful, otherwise false
 * offer(E e, long timeout, TimeUnit unit) – tries to insert element into a queue and waits for an available slot within a specified timeout
 * <p>
 * Retrieving Elements
 * take() – waits for a head element of a queue and removes it. If the queue is empty, it blocks and waits for an element to become available
 * poll(long timeout, TimeUnit unit) – retrieves and removes the head of the queue, waiting up to the specified wait time if necessary for an element to become available. Returns null after a timeout
 */
// Following is a producer-consumer implementation using BlockingQueue
public class _13_BlockingQueue {

    private static class Producer implements Runnable {

        private BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int counter = 1;
            while (true) {
                try {
                    System.out.println("Produced " + counter);
                    queue.put(counter);
                    counter++;
                    Thread.sleep(2000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static class Consumer implements Runnable {

        private BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                if (queue.size() > 0) {
                    try {
                        Thread.sleep(2500l);
                        System.out.println("Consuming " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue<>(10); // param : capacity

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
