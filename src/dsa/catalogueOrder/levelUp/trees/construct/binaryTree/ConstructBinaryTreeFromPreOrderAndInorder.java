package dsa.catalogueOrder.levelUp.trees.construct.binaryTree;

public class ConstructBinaryTreeFromPreOrderAndInorder {
    static private class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructBinaryTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0,preorder.length - 1, 0, inorder.length - 1);
    }

    // psi => PreorderStartingIndex
    // pei => PreorderEndingIndex
    // isi => InorderStartingIndex
    // iei => InorderEndingIndex
    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int psi, int pei, int isi, int iei) {
        if(isi > iei) return null; // base case

        int rootVal = preorder[psi];

        int idx = isi; // find position of root in the given inorder
        while(inorder[idx] != preorder[psi]) {
            idx++;
        }

        int leftSubtreeCount = idx - isi;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(preorder, inorder, psi+1, psi + leftSubtreeCount, isi, idx - 1);
        root.right = buildTreeHelper(preorder, inorder, psi + leftSubtreeCount + 1, pei, idx + 1, iei);

        return root;
    }
}
