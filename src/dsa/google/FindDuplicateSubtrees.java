package dsa.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-duplicate-subtrees/
public class FindDuplicateSubtrees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    String delimiter = "#";
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        Map<String, List<TreeNode>> map = new HashMap<>();
        serialize(root, map);

        for(List<TreeNode> list : map.values()) {
            if(list.size() > 1) result.add(list.get(0));
        }

        return result;
    }

    private String serialize(TreeNode root, Map<String, List<TreeNode>> map) {
        if(root == null) return "";

        String leftSerial = serialize(root.left, map);

        // if(leftSerial != "")
        //     map.put(leftSerial, map.getOrDefault(leftSerial, 0) + 1);

        String rightSerial = serialize(root.right, map);

        // if(rightSerial != "")
        //     map.put(right, map.getOrDefault(rightSerial, 0) + 1);

        StringBuilder sb = new StringBuilder("");
        sb.append(root.val);
        sb.append(delimiter);
        sb.append(leftSerial);
        sb.append(delimiter);
        sb.append(rightSerial);
        String mySerial = sb.toString();

        List<TreeNode> list = map.getOrDefault(mySerial, new ArrayList<>());
        list.add(root);
        map.put(mySerial, list);

        return mySerial;

    }
}
