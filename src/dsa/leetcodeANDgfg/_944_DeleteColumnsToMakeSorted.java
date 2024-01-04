package dsa.leetcodeANDgfg;

// Problem URL : https://leetcode.com/problems/delete-columns-to-make-sorted/description/
public class _944_DeleteColumnsToMakeSorted {
    // No Tricks involved... do as mentioned in the question description
    public int minDeletionSize(String[] strs) {
        int k = strs[0].length(); // column length
        int counter = 0;
        for(int col = 0; col < k; col++) {
            for(int row = 1; row < strs.length; row++) {
                String prev = strs[row - 1];
                String curr = strs[row];
                if(curr.charAt(col) < prev.charAt(col)) {
                    counter++;
                    break;
                }
            }
        }

        return counter;
    }
}
