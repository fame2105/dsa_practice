package dsa.leetcodeANDgfg;

import java.util.Arrays;
import java.util.HashMap;

public class _823_DP_BinaryTreeWithFactors {
    public int numFactoredBinaryTrees(int[] A) {
        long MOD = 1000000007l;
        Arrays.sort(A);

        HashMap<Integer, Long> dp = new HashMap<>(); // RootVal : number of unique trees that can be formed
        long sum = 0l;
        for(int val : A)
            dp.put(val, 1l);

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i]%A[j] == 0) { // A[j] is the leftChild
                    if(dp.containsKey(A[i]/A[j])) { // check if rightChild = A[i]/A[j] exists in the given Aay
                        dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i]/A[j])) % MOD);
                        sum = (sum + dp.get(A[i])) % MOD;
                    }
                }
            }
        }

        return (int) sum;
    }
}
