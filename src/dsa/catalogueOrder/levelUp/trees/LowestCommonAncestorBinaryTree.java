package dsa.catalogueOrder.levelUp.trees;

public class LowestCommonAncestorBinaryTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lcaHelper(root, p, q);
        return lca;
    }

    private TreeNode lca = null;
    private boolean lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean self = root.val == p.val || root.val == q.val;

        if(lca != null) return true;
        boolean left = lcaHelper(root.left, p, q);

        if(lca != null) return true;
        boolean right = lcaHelper(root.right, p, q);

        if((left && right) || (self && left) || (self && right)){
            lca = root;
        }
        return self || left || right;
    }
}
