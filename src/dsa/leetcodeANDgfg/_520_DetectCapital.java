package dsa.leetcodeANDgfg;

// Problem Description : https://leetcode.com/problems/detect-capital/description/
public class _520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n == 1) return true;

        if(Character.isUpperCase(word.charAt(0))) { // 1st character is capital
            if(Character.isUpperCase(word.charAt(1))) { // 2nd character is capital
                for(int i = 2; i < n; i++) { // Check if all the characters are capital -- CASE-1
                    if(Character.isLowerCase(word.charAt(i))) return false;
                }
            } else {
                for(int i = 1; i < n; i++) { // Check if only 1st character is capital -- CASE-2
                    if(Character.isUpperCase(word.charAt(i))) return false;
                }
            }
        } else {
            for(int i = 1; i < n; i++) { // Check if all the character are lower case -- CASE-3
                if(Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
