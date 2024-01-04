package dsa.catalogueOrder.levelUp.dynamicProgramming.catalanNumbers;

// https://leetcode.com/problems/unique-binary-search-trees/
// Exactly same as finding NthCatalanNumber -> code could be written in 2 ways... both are essentially similar
public class NumberOfBsts {
    /* public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            int left = 0;
            int right = i-1;
            int bstCountFor_i_Nodes = 0;
            while( left <= i-1) {
                bstCountFor_i_Nodes += dp[left] * dp[right];
                left++;
                right--;
            }
            dp[i] = bstCountFor_i_Nodes;
        }
        return dp[n];
    } */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            int bstCountFor_i_Nodes = 0;
            for(int j = 0; j < i; j++) {
                bstCountFor_i_Nodes += dp[j] * dp[i-j-1];
            }
            dp[i] = bstCountFor_i_Nodes;
        }
        return dp[n];
    }
}
