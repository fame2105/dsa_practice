package dsa.catalogueOrder.levelUp.trees;

public class Diameter {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Approach - 01 // O(n2)
    public static int diameterOfBinaryTree_01(TreeNode root) {
        int leftDiameter = diameterOfBinaryTree_01(root.left);
        int rightDiameter = diameterOfBinaryTree_01(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myDiameter = leftHeight + rightHeight + 2;

        return Math.max(leftDiameter, Math.max(rightDiameter, myDiameter));
    }

    private static int height(TreeNode node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.left)) + 1;
    }

//    ----------------------------------------------------------------------------------


    //    Approach - 02 , we could also use a class to make a pair and pass at each level
//    this is a better approach, since it takes only O(n) timt to computer the result
//    [0] -> diameter
//    [1] -> height
    public static int diameterOfBinaryTree_02(TreeNode root) {
        int[] ans = diameterOfBinaryTreeHelper_02(root);
        return ans[0];
    }

    private static int[] diameterOfBinaryTreeHelper_02(TreeNode root) {
        if (root == null) return new int[]{0, -1};

        int[] leftResult = diameterOfBinaryTreeHelper_02(root.left);
        int[] rightResult = diameterOfBinaryTreeHelper_02(root.right);

        int[] myResult = new int[2];
        myResult[0] = Math.max(leftResult[0], Math.max(rightResult[0], leftResult[1] + rightResult[1] + 2));

        myResult[1] = Math.max(leftResult[1], rightResult[1]) + 1;

        return myResult;
    }

}
