package mutithreading.questions;

// Following is an implementation using wait() and notify()
// this is also known as ProducerConsumer/ BlockingQueue problem
public class BoundedBuffer {
    int[] arr;
    int size;
    int capacity;
    int front;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
        this.front = 0;
    }

    public synchronized void enqueue(int data) throws InterruptedException {
        while (size == arr.length) {
//            System.out.println("Overflow");
            wait();
        }

        int rear = (front + size) % arr.length;
        arr[rear] = data;
        size++;
        notifyAll();
        Thread.sleep(500);
    }

    public synchronized int dequeue() throws InterruptedException {
        while (size == 0) {
//            System.out.println("Underflow");
            wait();
        }

        Thread.sleep(500);
        int position = front % arr.length;
        int data = arr[position];
        front++;
        size--;
        notifyAll();
        return data;
    }

    public synchronized void display() {
        System.out.println("---Displaying Queue---");
        for (int i = 0; i < size; i++) {
            int position = (front + i) % arr.length;
            System.out.print(arr[position] + " ");
        }
        System.out.println();
    }
}

class BoundedBufferDriver {
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer = new BoundedBuffer(3);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 50; i++) {
                    try {
                        buffer.enqueue(i);
                        System.out.println("produced "+ i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 25; i++) {
                    try {
                        System.out.println("dequeued "+ buffer.dequeue() + " by consumer1");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 25; i++) {
                    try {
                        System.out.println("dequeued "+ buffer.dequeue() + " by consumer2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        Thread.sleep(2000);

        consumer1.start();
        consumer2.start();

        consumer1.join();
        consumer2.join();
        producer.join();
    }
}
