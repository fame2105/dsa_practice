package dsa.leetcodeANDgfg.Greedy;

// https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
public class _2193_MinimumMovesToMakePalindrome {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(minMovesToMakePalindrome(s));
    }

    public static int minMovesToMakePalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        int count = 0;
        char[] sr = s.toCharArray();

        while(left < right) {
            int l = left; // iterating on copy of left and right pointers
            int r = right;

            // keep left fixed and decrease right pointer till sr[l] != sr[r]
            // we do this, because we want to make characters at left and right to be equal
            // the number of times r has decreased, will be the number of times we will swap characters of r and r+1
            while(l < r && sr[l] != sr[r]) r--;

            // this situation arises when there are odd number of characters in the string
            // ex: abb     l is at 'a' and r is at 'b'  r will have stopped at l
            // move this character one place forward, we want to place odd characters in between
            if(l == r) {
                swap(sr, r, r+1);
                count++;
                continue;
            }

            while(r < right) { // swap characters (right - r) times between r and r+1
                swap(sr, r, r+1);
                r++;
                count++;
            }

            left++;
            right--;
        }

        return count;
    }

    private static void swap(char[] sr, int left, int right) {
        char temp = sr[left];
        sr[left] = sr[right];
        sr[right] = temp;
    }
}
