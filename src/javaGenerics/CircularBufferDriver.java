package javaGenerics;

public class CircularBufferDriver {
    public static void main(String[] args) {
        int size = 5;
        CircularBuffer circularBuffer = new CircularBuffer(size);
        circularBuffer.offer("a");
        circularBuffer.offer("bc");
        circularBuffer.offer("d");

        circularBuffer.offer(1); // ClassCastException while casting and object from Integer to String

        print(circularBuffer);
    }

    public static void print(CircularBuffer buffer) {
        StringBuilder sb = new StringBuilder("");

        String val;
        while((val = (String) buffer.poll()) != null) {
            sb.append(val);
        }

        System.out.println(sb.toString());
    }
}
