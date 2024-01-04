package dsa.leetcodeANDgfg;

import java.util.HashMap;

// https://leetcode.com/problems/largest-palindromic-number/ # Contest
public class _2384_LargestPalindromicNumber {
    public static void main(String[] args) {
//        String ans = largestPalindromic("444947137");
//        String ans = largestPalindromic("00");
//        String ans = largestPalindromic("99999999");
//        String ans = largestPalindromic("00000000");
//        String ans = largestPalindromic("000000000");
//        String ans = largestPalindromic("009000");
//        String ans = largestPalindromic("10000000001");
        String ans = largestPalindromic("00011");
//        String ans = largestPalindromic("909");
        System.out.println(ans);
    }
    public static String largestPalindromic(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (char c : num.toCharArray())
            map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);

        StringBuilder res = new StringBuilder("");
        // Construct outer parts of Palindrome like this : 98__89  using decreasing numbers
        for(int i = 9; i >= 0; i--) {
            if(map.containsKey(i)) {
                int countPairs = map.get(i) / 2;
                if(i == 0 && res.length() == 0) {
                    break;
                }
                while(countPairs > 0) {
                    res.append(i);
                    countPairs--;
                }
            }
        }

        // Constructing the mid part... get the biggest number in the String which is of odd occurence
        // we do not want to consider the number of even occurence, because those all would already be used up in making outer part
        // We could also construct a mid part using String but using int seemed convininet at the time
        int max = 0;
        boolean updated = false; // if all the numbers in the string are in Pairs, then we do not have a midPart and it would essentially be 0.
        for(int key : map.keySet()) {
            if(map.get(key) % 2 == 1 && key >= max) { // get the max odd frequency number in the String
                max = key;
                updated = true;
            }
        }

        if(updated == false) { //  max would be 0 by default
            if(res.length() == 0) return "" + max; // we return 0 if the String couldn't be formed or it contained all zeroes... in those cases we have to return 0
            else return res.toString() + res.reverse().toString();
        } else {
            return res.toString() + max + res.reverse().toString();
        }
    }
}
