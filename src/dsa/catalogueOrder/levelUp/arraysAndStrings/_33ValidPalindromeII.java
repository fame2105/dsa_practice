package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _33ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                boolean checkLeft = isPalindrome(s, left, right-1);
                boolean checkRight = isPalindrome(s, left+1, right);
                return checkLeft || checkRight;
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
