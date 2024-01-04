package dsa.catalogueOrder.levelUp.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SuperUglyNumbers {

    // Approach 01 : No Optimizations -> O(primes.length * k)
    public int kthUglyNumber(int[] primes, int k) {
         int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);

        int[] dp = new int[k+1];
        dp[1] = 1;

         for(int i = 2; i < k+1; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                int primeNo = primes[j];
                int factor = primeNo * dp[pointers[j]];
                min = Math.min(min, factor);
            }

            dp[i] = min;

             for(int j = 0; j < primes.length; j++) {
                 int primeNo = primes[j];
                 int factor = primeNo * dp[pointers[j]];
                 if(factor == min) {
                     pointers[j]++;
                 }
             }
         }
        return dp[k];
    }

    // Approach 01 : Using PriorityQueue -> O(primes.length * k)
    public int kthUglyNumber_approach2(int[] primes, int k) {
        int[] dp = new int[k+1];
        dp[1] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }
        });

        for(int i = 0; i < primes.length; i++) {
            pq.add(new Pair(primes[i], 1, primes[i] * dp[1]));
        }

        for(int i = 2; i < k+1;) {
            Pair minFactor = pq.remove();
            if (dp[i - 1] != minFactor.val) {
                dp[i] = minFactor.val;
                i++;
            }
            pq.add(new Pair(minFactor.primeNo, minFactor.pointer + 1, minFactor.primeNo * dp[minFactor.pointer + 1]));
        }
        return dp[k];
    }

    private static class Pair {
        int primeNo;
        int pointer;
        int val;

        public Pair(int primeNo, int pointer, int val) {
            this.primeNo = primeNo;
            this.pointer = pointer;
            this.val = val;
        }
    }
}
