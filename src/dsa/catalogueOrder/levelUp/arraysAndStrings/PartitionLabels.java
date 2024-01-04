package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/partition-labels/
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("eaaaabaaec"));
    }

    /**
     * ou are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
     *
     * Return a list of integers representing the size of these parts.
     *
     * Example 1:
     * Input: s = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
     *
     * Example 2:
     * Input: s = "eccbbbbdec"
     * Output: [10]
     */

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();
        int prevIdx = 0;
        int lastOccuranceIdx = 0;
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            lastOccuranceIdx = Math.max(lastOccuranceIdx, map.get(c));

            if(lastOccuranceIdx == i) {
                ans.add(i - prevIdx + 1);
                prevIdx = i + 1;
            }

            i++;
        }

        return ans;
    }
}
