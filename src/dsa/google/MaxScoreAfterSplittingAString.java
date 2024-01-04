package dsa.google;

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/
public class MaxScoreAfterSplittingAString {
    public int maxScore(String s) {
        int count0 = 0;
        int count1 = 0;

        if (s.charAt(0) == '0') // the very firstOne at 0th index will never be counted, so only look for 0
            count0++;

        // count 1s
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count1++;
        }

        int maxSum = count0 + count1;

        // count 0s and update 1s
        for (int i = 1; i < s.length(); i++) {
            maxSum = Math.max(maxSum, count0 + count1);

            if (s.charAt(i) == '1')
                count1--;
            else
                count0++;
        }

        return maxSum;
    }
}
