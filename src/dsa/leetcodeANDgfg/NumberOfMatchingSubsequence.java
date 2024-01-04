package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/number-of-matching-subsequences/
// Editorial : https://www.youtube.com/watch?v=Mc--V-qHoDM
public class NumberOfMatchingSubsequence {
    public static void main(String[] args) {
        String s1 = "dsahjpjauf";
        String[] words1 = {"ahjpjau","ja", "ahbwzgqnuk","tnmlanowax"};
        System.out.println(numMatchingSubseq(s1, words1));

        System.out.println("-------------------");

        String s2 = "abcde";
        String[] words2 = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s2, words2));
    }
    /**
     * The idea is to check if the words provided in the query are a valid subsequence of S or not,
     * this does not mean we should be finding all the subsequences of S and then check if each word
     * present in the list of subsequences generated.
     *
     *Constraints in the question will not allow us to generate all the subsequences anyway.
     *
     * so another way to check if a word is a valid subsequence of S is to validate that
     * the index of each character in the word is increasing in a simultaneous manner as in the given S.
     */
    public static int numMatchingSubseq(String s, String[] words) {

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>(); // character : [position/idx of characters occuring in the string, its an arrayList because we could have same character repeating in the String]
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        int count = 0;
        for(String word : words) {

            int lastCharIdx = -1;
            boolean isSubsequence = true;

            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<>());
                int idx = upperBoundSearch(list, lastCharIdx);

                if(idx <= lastCharIdx) {
                    isSubsequence = false;
                    break;
                } else {
                    lastCharIdx = idx;
                }
            }

            if(isSubsequence == true) count += 1;
        }

        return count;
    }

    // Return an idx from list and that idx should be just greater than upperBound
    private static int upperBoundSearch(ArrayList<Integer> list, int upperBound) {
        int lo = 0;
        int high = list.size() - 1;
        int firstIdx = -1; // this is the index in the list that could contain the potential value(idx of chacracter in given string)

        while(lo <= high) {
            int mid = (lo + high) / 2;
			/*
			found a value(idx of char in original string) that is bigger than the upperbound/lastCharacterIdx in the word, mark mid as a potential answer ans search towards the left to see if we can find an lower values which are still greater than upperBound.
			*/
            if(upperBound < list.get(mid)) {
                firstIdx = mid;
                high = mid - 1;
            } else { // search in the second half, value which are <= upperBound are of no use to us.
                lo = mid + 1;
            }
        }

        // if we couldn't find the smallest value in list which is greater than upperBound then return -1 otherwise return the value present at firstIdx
        if(firstIdx != -1 && list.get(firstIdx) > upperBound) return list.get(firstIdx);
        else return -1;
    }
}
