package dsa.dpMasterCourseUdemy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solution("", result, 0, 0, n, 0);
        return result;
    }

    private static void solution(String output, List<String> result, int open, int close, int n, int idx) {
        if(idx == n*2) {
            result.add(output);
            return;
        }

        if(open < n) {
            solution(output + "(", result, open+1, close, n, idx+1);
        }

        if(close < open) {
            solution(output + ")", result, open, close+1, n, idx+1);
        }
    }
}
