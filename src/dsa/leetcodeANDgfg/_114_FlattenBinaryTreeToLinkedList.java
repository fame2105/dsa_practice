package dsa.leetcodeANDgfg;

import java.util.Stack;

public class _114_FlattenBinaryTreeToLinkedList {

      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public TreeNode flatten(TreeNode root) {
        flattenHelper(root);
        return root;
    }

    private TreeNode ptr = null;

    /**
     * Recursive Approach :
     * first handle the right child then left child
     * if a child node is pointed by a ptr/temp, then its parent should point to it in post order
     * When returning from any node, make it referred by ptr and the parentNode's right will point to ptr.
     * this happens recursively
     *
     * This is an easy implementation, dry-run it once to understand it completely
     */
    private void flattenHelper(TreeNode root) {
        if(root == null)
            return;

        flattenHelper(root.right);
        flattenHelper(root.left);

        root.right = ptr;
        root.left = null;
        ptr = root;
    }


    private void iterativeflatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.size() > 0) {
            TreeNode rem = st.pop();

            if(rem.right != null) {
                st.push(rem.right);
            }

            if(rem.left != null) {
                st.push(rem.left);
            }


            if(st.size() > 0) {
                rem.right = st.peek();
                rem.left = null;
            }
        }
    }
}
