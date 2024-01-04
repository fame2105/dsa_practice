package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class _28SegmentedSieve {

    public static void segmentedSieveAlgo(int a, int b) {
        // Generate primes till sqrt(b)
        List<Integer> primes = generatePrimesUsingSieve((int) Math.sqrt(b));

        boolean[] arr = new boolean[b - a + 1];

        for (int prime : primes) {
            int multiple = (int) Math.ceil((a * 1.0) / prime);

            if (multiple == 1)
                multiple++;

            int idx = prime * multiple - a;
            for (int i = idx; i < arr.length; i += prime) {
                arr[i] = true;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false && a + i > 1) {
                int val = a + i;
                System.out.println(val);
            }
        }
    }

    private static List<Integer> generatePrimesUsingSieve(int n) {
        boolean[] primes = new boolean[n + 1]; // false -> prime    true -> not prime

        for (int i = 2; i * i <= primes.length; i++) {
            if (primes[i] == false) {
                for (int j = i + i; j < primes.length; j+=i)
                    primes[j] = true;
            }
        }

        List<Integer> primeNos = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == false) primeNos.add(i);
        }

        return primeNos;
    }
}
