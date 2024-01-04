package dsa.leetcodeANDgfg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/count-vowels-permutation/
public class _1220_DP_CountVowelsPermutation {

    int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        // prepare map
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // a : 0, e : 1, i : 2, o : 3, u : 4
        map.put(0, Arrays.asList(1));
        map.put(1, Arrays.asList(0, 2));
        map.put(2, Arrays.asList(0, 1, 3, 4));
        map.put(3, Arrays.asList(2, 4));
        map.put(4, Arrays.asList(0));
        map.put(5, Arrays.asList(0, 1, 2, 3, 4));

        Integer[][] dp = new Integer[n+1][5];

        long sum = 0l;

        for(Integer c : map.get(5)) { // initial case n = 1 all vowels get a chance
            sum += dfs(n-1, c, map, dp);
        }

        return (int) (sum % MOD);
    }

    private long dfs(int n, Integer lc, HashMap<Integer, List<Integer>> map, Integer[][] dp) {
        if(n == 0) return 1;

        if(dp[n][lc] != null) return dp[n][lc];

        long count = 0l;
        for(Integer c : map.get(lc)) {
            count += dfs(n-1, c, map, dp);
        }

        dp[n][lc] = (int) (count % MOD);
        return dp[n][lc];
    }
}
