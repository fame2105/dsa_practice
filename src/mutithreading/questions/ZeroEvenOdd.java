package mutithreading.questions;

class ZeroEvenOdd {
    private int n;
    private static int counter;
    private volatile boolean callZero;
    private volatile boolean callEven;
    private volatile boolean callOdd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.counter = 2 * n;
        this.callZero = true;
        this.callEven = false;
        this.callOdd = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero() throws InterruptedException {
        while((callEven == true || callOdd == true) && counter > 0) {
            wait();
            System.out.println("0");
            counter--;
            callOdd = true;
            callZero = false;
            callEven = false;
            notifyAll();
        }
    }

    public synchronized void even() throws InterruptedException {

        while ((callEven == true || callOdd == true) && counter > 0) {
            wait();
            System.out.println("0");
            counter--;
            callOdd = true;
            callZero = false;
            callEven = false;
            notifyAll();
        }
    }

    public synchronized void odd() throws InterruptedException {

    }
}
