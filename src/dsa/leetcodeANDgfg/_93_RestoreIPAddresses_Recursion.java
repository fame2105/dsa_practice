package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/description/
// Editorial :  https://www.youtube.com/watch?v=qu4W3idglP4&ab_channel=Pepcoding
public class _93_RestoreIPAddresses_Recursion {

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<>();
        helper(s, 0, 0, "", list);
        return list;
    }

    private void helper(String s, int idx, int partitions, String ans, ArrayList<String> list) {
        if(idx == s.length() || partitions == 4) {
            if(idx == s.length() && partitions == 4) {
                list.add(ans.substring(0, ans.length()-1));
            }
            return;
        }

        helper(s, idx+1, partitions + 1, ans + s.charAt(idx) + ".", list);

        if(idx + 2 <= s.length() && isValid(s.substring(idx, idx+2)))
            helper(s, idx+2, partitions + 1, ans + s.substring(idx, idx+2) + ".", list);

        if(idx + 3 <= s.length() && isValid(s.substring(idx, idx+3)))
            helper(s, idx+3, partitions + 1, ans + s.substring(idx, idx+3) + ".", list);
    }

    private boolean isValid(String s) {
        if(s.charAt(0) == '0')
            return false;

        return Integer.parseInt(s) <= 255;
    }
}
