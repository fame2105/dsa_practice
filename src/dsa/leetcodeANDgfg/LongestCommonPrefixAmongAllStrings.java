package dsa.leetcodeANDgfg;

// Easy : https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefixAmongAllStrings {
    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 1) return strings[0];

        StringBuilder longestCommonPrefix = new StringBuilder(strings[0]);

        for (int i = 1; i < strings.length; i++) {
            String current = strings[i];

            int j = 0;
            StringBuilder prefix = new StringBuilder("");
            while(j < current.length() && j < longestCommonPrefix.length() && current.charAt(j) == longestCommonPrefix.charAt(j)) {
                prefix.append(current.charAt(j));
                j++;
            }

            if(j == 0) return "";

            if(j < longestCommonPrefix.length()) {
                longestCommonPrefix = prefix;
            }
        }

        return longestCommonPrefix.toString();
    }
}
