package dsa.catalogueOrder.levelUp.arraysAndStrings;

// 1750 https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
public class MinimumLengthoStringAfterDeletingSimilarEnds {

    public int minimumLength(String s) {
        if(s.length() == 1) return 1;

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if(lc == rc) {
                while(left < s.length() && s.charAt(left) == lc) left++;
                while(right >=0 && s.charAt(right) == rc) right--;
            } else {
                break;
            }
        }

        return left > right ? 0 : right - left + 1;
    }
}
