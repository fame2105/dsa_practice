package dsa.catalogueOrder.foundation.stackAndQueue.queue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 5;
        printBinaryNumbers(n);
    }

    private static void printBinaryNumbers(int n) {
        ArrayDeque<String> q = new ArrayDeque<>();

        q.push("1");

        while (n >= 1) {
            String current = q.removeLast();
            System.out.println(current);
            q.push(current + "0");
            q.push(current + 1);
            n--;
        }
    }
}
