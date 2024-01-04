package dsa.leetcodeANDgfg;

import dsa.utility.TreeNode;

public class _100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // check self node value
        if(p == null && q == null) {
            return true;
        } else if(p == null && q!= null) {
            return false;
        } else if(p!= null && q == null) {
            return false;
        } else if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
