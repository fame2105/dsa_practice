package javaGenerics;

public class CircularBufferGenericDriver {
    public static void main(String[] args) {
        int size = 5;
        CircularBufferGeneric<String> circularBuffer = new CircularBufferGeneric<>(size);
        circularBuffer.offer("a");
        circularBuffer.offer("bc");
        circularBuffer.offer("d");

//        circularBuffer.offer(1); // No ClassCastException will occur during run time, because it would be caught during compilation itself

        print(circularBuffer);
    }

    public static void print(CircularBufferGeneric<String> buffer) {
        StringBuilder sb = new StringBuilder("");

        String val;
        while((val = (String) buffer.poll()) != null) {
            sb.append(val);
        }

        System.out.println(sb.toString());
    }
}
