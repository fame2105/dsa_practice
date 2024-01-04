package dsa.leetcodeANDgfg;

import java.util.HashMap;

// https://leetcode.com/problems/reordered-power-of-2/
public class _869_ReorderedPowerOf2 {
    /**
     * Given in question that 1 <= n <= 10^9
     * Solution Approach :
     *
     * Step 1: Traverse from 1 to 10^9 in powers of 2 -> i ; and store a frequencyCount in an array for each i;  => log(10^9) base 2
     * Step 2 : Now store a frequencyCount in an array for `n`. ... we call it nCount[]
     * Step 3: Traverse from 1 to 10^9 or traverse on each of the keys in the map and see if (map.get(key) == nCount[]) .. either use Arrays.equals(arr1, arr2) or a loop to check if arrays are equal
     *
     * We don't need to rearrange the given `n` in order to check if it could be reordered to a power of 2 and neither do we need to mind leading 0's
     * Since all the keys in the map are powers of 2. we just need to check if the key is made up of same Integers as the given `n`
     */
    public boolean reorderedPowerOf2(int n) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int x = (int) Math.pow(10, 9);
        for(int i = 1; i <= x; i=i*2) {
            int num = i;
            int[] numCount = map.getOrDefault(i, new int[10]);
            while(num != 0) {
                int rem = num % 10;
                numCount[rem] += 1;
                num = num/10;
            }
            map.put(i, numCount);
        }

        int[] nCount = new int[10];
        while(n != 0) {
            int rem = n % 10;
            nCount[rem] += 1;
            n = n/10;
        }

        for(int i = 1; i < x; i=i*2) {
            int[] numCount = map.get(i);
            boolean flag = true;
            for(int j = 0; j < 10; j++) {
                if(numCount[j] != nCount[j]) {
                    flag = false;
                    break;
                }
            }

            if(flag == true) return true;
        }

        return false;
    }
}
