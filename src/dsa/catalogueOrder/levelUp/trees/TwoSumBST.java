package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TwoSumBST {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Approach 01
    public static List<List<Integer>> findTarget_approach01(TreeNode root, int k) {
        List<List<Integer>> result = new ArrayList<>();
        findTarget(root, root, k, result);
        return result;
    }

    private static boolean findTarget(TreeNode root, TreeNode node, int k, List<List<Integer>> result) {
        if (node == null) return false;

        int target = k - node.val;
        if (target != node.val) {
            boolean foundInTree = find(root, target);
            if (foundInTree == true) result.add(Arrays.asList(node.val, target));
        }

        boolean resultLeft = findTarget(root, node.left, k, result);
        boolean resultRight = findTarget(root, node.right, k, result);
        return resultLeft || resultRight;
    }

    private static boolean find(TreeNode root, int target) {
        if (root == null) return false;

        if (target == root.val) return true;
        else if (target < root.val) return find(root.left, target);
        else return find(root.right, target);
    }

    // ------------------------------------------------------------------------------------

    // Approach 02 -> Get an arrayList of inorder traversal and apply twoSumApproach
    public static List<List<Integer>> findTarget_approach02(List<Integer> numbers, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = numbers.size() - 1;
        int sum = 0;
        while (left < right) {
            sum = numbers.get(left) + numbers.get(right);

            if (sum < target) left++;
            else if (sum > target) right--;
            else {
                result.add(Arrays.asList(numbers.get(left), numbers.get(right)));
            }
        }
        return result;
    }

    // ------------------------------------------------------------------------------------

    // Approach 03 -> Best Approach : time complexity : O(n) and space complexity : O(h)
    public static List<List<Integer>> findTarget_approach03(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Pair> inorderStack = new Stack<>(); // increasing
        Stack<Pair> reverseInorderStack = new Stack<>(); // decreasing

        inorderStack.push(new Pair(root, 0));
        reverseInorderStack.push(new Pair(root, 0));

        TreeNode left = getNextFromInorder(inorderStack);
        TreeNode right = getNextFromReverseInorderStack(reverseInorderStack);
        while (left.val < right.val) {
            if (left.val + right.val < target) {
                left = getNextFromInorder(inorderStack);
            } else if (left.val + right.val > target) {
                right = getNextFromReverseInorderStack(reverseInorderStack);
            } else {
                result.add(Arrays.asList(left.val, right.val));
                left = getNextFromInorder(inorderStack);
                right = getNextFromReverseInorderStack(reverseInorderStack);
            }
        }
        return result;
    }

    private static TreeNode getNextFromReverseInorderStack(Stack<Pair> reverseInorderStack) {
        while (reverseInorderStack.size() > 0) {
            Pair p = reverseInorderStack.peek();

            if (p.state == 0) {
                if (p.node.right != null) reverseInorderStack.push(new Pair(p.node.right, 0));
                p.state++;
            } else if (p.state == 1) {
                if (p.node.left != null) reverseInorderStack.push(new Pair(p.node.left, 0));
                p.state++;
                return p.node;
            } else {
                reverseInorderStack.pop();
            }
        }
        return null;
    }

    private static TreeNode getNextFromInorder(Stack<Pair> inorderStack) {
        while (inorderStack.size() > 0) {
            Pair p = inorderStack.peek();

            if (p.state == 0) {
                if (p.node.left != null) inorderStack.push(new Pair(p.node.left, 0));
                p.state++;
            } else if (p.state == 1) {
                if (p.node.right != null) inorderStack.push(new Pair(p.node.right, 0));
                p.state++;
                return p.node;
            } else {
                inorderStack.pop();
            }
        }
        return null;
    }

    private static class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}
