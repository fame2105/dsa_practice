package dsa.catalogueOrder.levelUp.trees;

public class _337_HouseRobber_BinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private class State {
        int maxProfitWithRobbery;
        int maxProfitWithoutRobbery;

        State(int maxProfitWithRobbery, int maxProfitWithoutRobbery) {
            this.maxProfitWithRobbery = maxProfitWithRobbery;
            this.maxProfitWithoutRobbery = maxProfitWithoutRobbery;
        }
    }

    public int rob(TreeNode root) {
        State rootState = robHelper(root);
        return Math.max(rootState.maxProfitWithRobbery, rootState.maxProfitWithoutRobbery);
    }

    private State robHelper(TreeNode root) {
        if (root == null) return new State(0, 0);

        State leftState = robHelper(root.left);
        State rightState = robHelper(root.right);

        int myProfitWithRobbery = leftState.maxProfitWithoutRobbery + rightState.maxProfitWithoutRobbery + root.val;

        int myProfitWithoutRobbery = Math.max(leftState.maxProfitWithoutRobbery, leftState.maxProfitWithRobbery) + Math.max(rightState.maxProfitWithoutRobbery, rightState.maxProfitWithRobbery);

        State myState = new State(myProfitWithRobbery, myProfitWithoutRobbery);

        return myState;
    }
}
