package mutithreading.multithreadingAndParallelComputing;

import java.util.LinkedList;
import java.util.Queue;

public class _7_ProducerConsumer {
    public static void main(String[] args) {
        ProducerAndConsumerImpl processor = new ProducerAndConsumerImpl(5);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProducerAndConsumerImpl {
    private Queue<Integer> queue;
    private int capacity;
    private final Object lock = new Object();

    public ProducerAndConsumerImpl(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void produce() throws InterruptedException {
        int counter = 1;
        synchronized (lock) {
            while (true) {
                if (counter <= capacity) {
                    System.out.println("Producing : " + counter);
                    queue.add(counter);
                    counter++;
                    lock.notify();
                } else {
                    counter = 1;
                    System.out.println("Queue at maximum capacity... start consuming");
                    lock.wait();
                }

                Thread.sleep(600);
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (lock) {
            while (true) {
                if (queue.size() > 0) {
                    System.out.println("Consuming : " + queue.remove());
                    lock.notify();
                } else {
                    System.out.println("Queue is Empty, cannot consume");
                    lock.wait();
                }

                Thread.sleep(600);
            }
        }
    }
}
