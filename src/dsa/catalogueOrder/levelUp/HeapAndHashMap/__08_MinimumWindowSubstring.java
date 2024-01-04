package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __08_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    // find smallest substring of s such that
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> template = new HashMap<>(); // HashMap for template String
        for(int i = 0; i < t.length(); i++) { // Add template String in HashMap
            char ch = t.charAt(i);
            template.put(ch, template.getOrDefault(ch, 0) + 1);
        }

        String ans = ""; // Initial Answer
        int desiredCount = t.length(); // we want ans substring(s) to be as close to desiredCount in length
        int myCount = 0; // denotes the count of characters that we are including in the map only if it is also present in templateMap and the frequency of that character in map is less than frequency of this character in templateMap

        HashMap<Character, Integer> map = new HashMap<>(); // Map for creating substring
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            // Keep adding characters in map till myCount < desiredCount
            while(j < s.length() && myCount < desiredCount) {
                char ch = s.charAt(j++);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // this check ensures that we increase myCount only if the character is present in template String
                if(map.getOrDefault(ch, 0) <= template.getOrDefault(ch, 0)) {
                    myCount++;
                }
            }

            // We are here because we have found our a potentialAnswer
            // Remove characters from map one at a time till myCount == desiredCount
            // As soon as myCount becomes less than desiredCount, we will start to add characters in map again
            if(i < j && myCount == desiredCount) {
                String potentialAns = s.substring(i, j);
                if(ans.isEmpty() || potentialAns.length() < ans.length()) { // initially ans is empty, hence we are placing the check for ans being empty
                    ans = potentialAns;
                }

                char ch = s.charAt(i);

                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                // this check ensures that we reduce myCount for only those characters that are present in the template String
                if(map.getOrDefault(ch, 0) < template.getOrDefault(ch, 0)) {
                    myCount--;
                }
            }
        }

        return ans;
    }
}
