package javaGenerics;

// Generic implementation of CircularBuffer
public class CircularBufferGeneric<T> {
    int size = 0;
    int readIdx;
    int writeIdx;
    T[] buffer; // all the places that are unfilled will have null as value

    public CircularBufferGeneric(int size) {
        this.size = size;
        buffer = (T[]) new Object[size];
        readIdx = 0;
        writeIdx = 0;
    }

    public boolean offer(T val) {
        if (buffer[writeIdx] != null) { // if there is already some data present at the writeIdx, then buffer is full
            return false; // buffer is filled, overflow condition
        }
        buffer[writeIdx] = val;
        writeIdx = next(writeIdx);
        return true;
    }

    public T poll() {
        T val = buffer[readIdx];
        if (val != null) { // if val is null then buffer is empty, and we shall return null
            buffer[readIdx] = null; // since val is not null, we empty the current readIdx position by inserting null.
            readIdx = next(readIdx);
        }

        return val;
    }

    private int next(int idx) {
        return (idx + 1) % buffer.length;
    }
}
