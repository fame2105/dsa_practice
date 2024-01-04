package mutithreading.questions;

public class FooBar {
    private int n;
    private volatile boolean callFoo;
    private volatile boolean callBar;

    public FooBar(int n) {
        this.n = n;
        this.callFoo = true;
        this.callBar = false;
    }

    private static final Object lock = new Object();

    public void foo() throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (callBar == true) {
                    lock.wait();
                }

                System.out.print("foo");
                callFoo = false;
                callBar = true;
                lock.notifyAll();
            }
        }
    }

    public void bar() throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (callFoo == true) {
                    lock.wait();
                }
                System.out.print("bar");
                callFoo = true;
                callBar = false;
                lock.notifyAll();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        FooBar fb = new FooBar(3);
        Thread t1 = new Thread(() -> {
            try {
                fb.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fb.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}

