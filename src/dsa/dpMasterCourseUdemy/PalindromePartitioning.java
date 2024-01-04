package dsa.dpMasterCourseUdemy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
// (Printing the palindromic partitions)
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solution(s, list, result);

        return result;
    }


    // recursion & backtracking approach
    private void solution(String s, List<String> list, List<List<String>> result) {
        if(s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i+1);
            String ros = s.substring(i+1);
            if(isPalindrome(prefix) == true) {
                list.add(prefix);
                solution(ros, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
