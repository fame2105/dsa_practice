package dsa.leetcodeANDgfg;

// 979 https://leetcode.com/problems/distribute-coins-in-binary-tree/
public class DistributeCoinsInBinaryTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static Integer moves = null;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        distributeCoinsHelper(root, root);
        return moves;
    }

    public void distributeCoinsHelper(TreeNode parent, TreeNode node) { // Traverse
        if (node == null) return;

        distributeCoinsHelper(node, node.left);

        distributeCoinsHelper(node, node.right);

        if (node.val > 1) { // this node has extra coins will give away extra coins to parent
            int extraCoins = node.val - 1;
            node.val = 1;
            parent.val += extraCoins;
            moves += extraCoins;
        } else if (node.val < 1) { // this node has less than 1 coins  -> will take needed coins from parent
            int needCoins = 1 + Math.abs(node.val);
            node.val = 1;
            moves += needCoins;
            parent.val = parent.val - needCoins;
        }
    }
}
