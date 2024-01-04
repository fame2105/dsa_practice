package dsa.catalogueOrder.levelUp.trees.iterator;

import java.util.Iterator;
import java.util.Stack;

public class BSTIteratorUsingStack {
    private static class BinarySearchTree implements Iterable<Integer> {

        private class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            public TreeNode(int val) {
                this.val = val;
                this.left = this.right = null;
            }
        }

        TreeNode root = null;

        private BinarySearchTree(Integer[] data) {
            construct(data);
        }

        private void construct(Integer[] data) {
        }

        @Override
        public Iterator<Integer> iterator() {
            return new BSTIterator();
        }

        private class BSTIterator implements Iterator<Integer> {

            private Stack<TreeNode> st;

            public BSTIterator() {
                this.st = new Stack<>();
                addAllLeft(root);
            }

            @Override
            public boolean hasNext() {
                return st.size() > 0 ? true : false;
            }

            @Override
            public Integer next() {
                TreeNode topNode = st.pop();
                addAllLeft(topNode.right);
                return topNode.val;
            }

            private void addAllLeft(TreeNode node) {
                while (node != null) {
                    this.st.push(node);
                    node = node.left;
                }
            }
        }
    }
}
