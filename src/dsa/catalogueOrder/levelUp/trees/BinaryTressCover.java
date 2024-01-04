package dsa.catalogueOrder.levelUp.trees;

public class BinaryTressCover {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int camera = 0;

    public int minCameraCover(TreeNode root) {
        camera = 0;
        int state = minCameraCoverHelper(root);

        if (state == 2) return camera + 1;

        return camera;

    }

    // 0 -> camera placed ...safe
    // 2 -> camera not placed ...unsafe
    // 1 -> camera not placed ...safe
    private int minCameraCoverHelper(TreeNode root) {
        if (root == null) return 1;

        int lState = minCameraCoverHelper(root.left);
        int rState = minCameraCoverHelper(root.right);

        if (lState == 1 && rState == 1) {
            return 2;
        } else if (lState == 2 || rState == 2) {
            camera++;
            return 0;
        } else {
            return 1;
        }
    }

}
