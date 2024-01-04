package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.Arrays;

public class _27SieveOfEratosthenes {

    public static void main(String[] args) {
        printPrimeUsingSieve(10);
    }

    public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i < isPrime.length; i++) {
            if(isPrime[i] == true) {
                for(int j = i+i; j < isPrime.length; j = j+i)
                    isPrime[j] = false;
            }
        }

        for(int i = 2; i <= n; i++) {
            if(isPrime[i])
                System.out.print(i + " ");
        }
    }
}
