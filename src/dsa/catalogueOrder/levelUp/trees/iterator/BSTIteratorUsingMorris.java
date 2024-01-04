package dsa.catalogueOrder.levelUp.trees.iterator;

import java.util.Iterator;
import java.util.Stack;

public class BSTIteratorUsingMorris {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    private class BSTIterator implements Iterator<Integer> {


        public BSTIterator() {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }
    }
}
