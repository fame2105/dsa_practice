package dsa.catalogueOrder.levelUp.trees;

public class SerializeAndDeserializeBinaryTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serialize_(root, sb);
        return sb.toString();
    }

    private void serialize_(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serialize_(root.left, sb);
        serialize_(root.right, sb);
    }

    // Decodes your encoded data to tree.
    private static int idx = 0;
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;

        idx = 0;
        String[] arr = data.split(",");
        TreeNode root = deserialize_(arr);
        return root;
    }

    private TreeNode deserialize_(String[] arr) {
        if(idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize_(arr);
        node.right = deserialize_(arr);
        return node;
    }
}
