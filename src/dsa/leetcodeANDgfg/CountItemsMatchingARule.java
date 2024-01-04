package dsa.leetcodeANDgfg;

// 1773. Count Items Matching a Rule

import java.util.List;

public class CountItemsMatchingARule {
    public static void main(String[] args) {
//        List<List<String>> input1 =
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if(ruleKey.equals("type")) {
            return (int) items.stream().filter(item -> item.get(0).equals(ruleValue)).count();
        } else if (ruleKey.equals("color")) {
            return (int) items.stream().filter(item -> item.get(1).equals(ruleValue)).count();
        } else if (ruleKey.equals("name")) {
            return (int) items.stream().filter(item -> item.get(2).equals(ruleValue)).count();
        } else {
            return 0;
        }
    }
}
