package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/bag-of-tokens/

public class _948_BagOfTokens {
    /**
     * 1. We would want to pay all the smaller tokens from our power and thus gaining score.
     * 2. If we do not have enough power, then we'd want to gain the power from maxToken by giving up
     * score by 1.
     * 3. This approach is precisely the reason why we have sorted the array in increasing order
     */
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0, right = tokens.length - 1;

        int score = 0, maxScore = 0;

        // If we reach a place, where we can't pay the token amount from power and neither
        // have enough score to consume the token then break and return... we can't move forward
        boolean flag = true;

        while(left <= right) {
            if(power >= tokens[left]) {
                power -= tokens[left];
                score += 1;
                left++;
                flag = false;
            } else if(score >= 1) {
                power += tokens[right];
                score -= 1;
                right--;
                flag = false;
            }

            maxScore = Math.max(score, maxScore);
            if(flag == true) break;
        }

        return maxScore;
    }
}
