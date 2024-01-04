package dsa.leetcodeANDgfg;

// Link : https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
// Editorial : https://leetcode.com/problems/flip-string-to-monotone-increasing/solutions/2912351/flip-string-to-monotone-increasing/?orderBy=most_votes

public class _926_FlipStringToMonotonicIncreasing_DP {
    public int minFlipsMonoIncr(String s) {
        /**
         * Assume that we start iteration at a certain point and String before that point is monotonic
         * Now, If we encounter 0 during our iteration then in order to keep a string monotonic we either flip all the onesEncountered
         * so far to 0 OR we flip current 0 to 1 ....
         * which ever operation is minimum in count we keep that as our ans

         * to summarize : In order to make sure that string remains monotonic (eihter flip the current encountered 0 to 1 or flip all the 1's encountered before to 0) whichever is min. among the two we do that operation.
         */
        int noOfFlipsMadeSoFar = 0, noOfOnesEncontered = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') {
                noOfOnesEncontered += 1;
            } else {
                noOfFlipsMadeSoFar = Math.min(noOfFlipsMadeSoFar + 1, noOfOnesEncontered);
            }
        }

        return noOfFlipsMadeSoFar;
    }
}
