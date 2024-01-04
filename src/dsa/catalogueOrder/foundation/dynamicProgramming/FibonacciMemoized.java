package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class FibonacciMemoized {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(getNthFibonacciMemoized(n, new int[n + 1]));
        System.out.println(getNthFibonacci(n));
    }


    private static int getNthFibonacciMemoized(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int fibn = getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
        qb[n] = fibn;
        return fibn;
    }


    private static int getNthFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
