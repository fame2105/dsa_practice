package dsa.leetcodeANDgfg;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-ice-cream-bars/description/

public class _1833_MaximumIceCreamBars_Greedy {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int counter = 0;
        for(int cost : costs) { // Buy ice cream bars till you have enough coins
            if(cost <= coins) {
                counter++;
                coins -= cost;
            } else {
                break;
            }
        }
        return counter;
    }
}
