package dsa.catalogueOrder.foundation.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    // dsa.utility class for Stack construction
    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static class Node {
        Node left = null;
        Node right = null;
        int data;

        Node(int data) {
            this.left = this.right = null;
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        driver();
    }


    public static void driver() {
        Integer[] input = new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = constructBinaryTree(input);

        System.out.println("------------------------------------------");
        display(root);

        System.out.println("------------------------------------------");
        int treeSize = size(root);
        System.out.println("Tree Size : " + treeSize);

        System.out.println("------------------------------------------");
        int treeSum = sum(root);
        System.out.println("Tree Sum : " + treeSum);

        System.out.println("------------------------------------------");
        int treeMax = max(root);
        System.out.println("Tree Max : " + treeMax);

        System.out.println("------------------------------------------");
        int treeHeight = height(root);
        System.out.println("Tree Height : " + treeHeight);

        System.out.println("------------------------------------------");
        System.out.println("Level Order Traversal of Binary Tree Approach 1");
        levelOrderTraversalApproach1(root);

        System.out.println("------------------------------------------");
        System.out.println("Level Order Traversal of Binary Tree Approach 2");
        levelOrderTraversalApproach2(root);

        System.out.println("------------------------------------------");
        System.out.println("Iterative Preorder Inorder and Postorder Traversals ");
        iterativePrePostAndInorderTraversal(root);

        System.out.println("------------------------------------------");
        System.out.println("K Level Down Approach - 01");
        KLevelsDownApproach1(root, 3);

        System.out.println("------------------------------------------");
        System.out.println("K Level Down - 02");
        KLevelsDownApproach2(root, 3);

    }

    public static Node constructBinaryTree(Integer[] input) {
        Node root = new Node(input[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        int idx = 1;
        while (!st.isEmpty()) {
            Pair p = st.peek();

            if (p.state == 0) {
                // process left child
                idx += 1;
                if (input[idx] != null) {
                    Node node = new Node(input[idx]);
                    p.node.left = node;
                    st.push(new Pair(node, 0));
                }

                p.state += 1;
            } else if (p.state == 1) {
                // process right child

                idx += 1;
                if (input[idx] != null) {
                    Node node = new Node(input[idx]);
                    p.node.right = node;
                    st.push(new Pair(node, 0));
                }

                p.state += 1;
            } else {
                // pop out node-pair from stack
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node root) {
        if (root == null) return;

        String str = root.left == null ? " ." : "" + root.left.data;
        str += " <- [" + root.data + "] -> ";
        str += root.right == null ? ". " : "" + root.right.data;

        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    public static int size(Node node) {
        if (node == null) return 0;
        int lSize = size(node.left);
        int rSize = size(node.right);
        return lSize + rSize + 1;
    }

    public static int sum(Node node) {
        if (node == null) return 0;
        int lSum = sum(node.left);
        int rSum = sum(node.right);
        return lSum + rSum + node.data;
    }

    public static int max(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int lMax = max(node.left);
        int rMax = max(node.right);
        return Math.max(lMax, Math.max(rMax, node.data));
    }

    public static int min(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        int lMin = min(node.left);
        int rMin = max(node.right);
        return Math.min(lMin, Math.max(rMin, node.data));
    }

    public static int height(Node node) {
        if (node == null) return -1;
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        return Math.max(lHeight, rHeight) + 1;
    }

    // approach - 1
    public static void levelOrderTraversalApproach1(Node node) {
        if (node == null) return;
        Queue<Node> mainQ = new LinkedList<>();
        Queue<Node> childQ = new LinkedList<>();

        mainQ.add(node);
        while (!mainQ.isEmpty()) {
            Node item = mainQ.remove();
            System.out.print(item.data + " ");

            if (item.left != null) childQ.add(item.left);
            if (item.right != null) childQ.add(item.left);

            if (mainQ.isEmpty()) {
                Queue temp = mainQ;
                mainQ = childQ;
                childQ = temp;
                System.out.println();
            }
        }
    }

    // approach - 2
    public static void levelOrderTraversalApproach2(Node node) {
        if (node == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int currentLevelSize = q.size();

            while (currentLevelSize >= 1) {
                // remove item from queue
                Node item = q.remove();

                // add children
                if (item.left != null) q.add(item.left);
                if (item.right != null) q.add(item.right);

                // print item data
                System.out.println(item.data + " ");

                currentLevelSize -= 1;
            }

            System.out.println();
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) return false;
        else if (node.data == data) return true;

        boolean foundInLeftSubTree = find(node.left, data);
        boolean foundInRightSubTree = false;
        if (foundInLeftSubTree == false) {
            foundInRightSubTree = find(node.right, data);
        }

        return foundInLeftSubTree || foundInRightSubTree;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<Integer>();
        } else if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> lList = nodeToRootPath(node.left, data);

        if (!lList.isEmpty()) {
            lList.add(node.data);
            return lList;
        }

        ArrayList<Integer> rList = nodeToRootPath(node.right, data);

        if (!rList.isEmpty()) {
            rList.add(node.data);
            return rList;
        }

        return new ArrayList<Integer>();
    }

    public static void iterativePrePostAndInorderTraversal(Node node) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.add(new Pair(node, 0));
        while (!st.isEmpty()) {
            Pair peekPair = st.peek();

            if (peekPair.state == 0) {
                preOrder.add(peekPair.node.data);
                peekPair.state += 1;

                if (peekPair.node.left != null) {
                    st.push(new Pair(peekPair.node.left, 0));
                }
            } else if (peekPair.state == 1) {
                inOrder.add(peekPair.node.data);
                peekPair.state += 1;

                if (peekPair.node.right != null) {
                    st.push(new Pair(peekPair.node.right, 0));
                }
            } else {
                postOrder.add(peekPair.node.data);
                st.pop();
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

    // print k Levels down - approach - 01 -> using level order traversal
    public static void KLevelsDownApproach1(Node node, int k) {
        if (node == null) return;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));

        while (!q.isEmpty()) {
            int currentLevelSize = q.size();

            while (currentLevelSize >= 1) {
                // remove item from queue
                Pair remove = q.remove();

                // add children
                if (remove.node.left != null) q.add(new Pair(remove.node.left, remove.state + 1));
                if (remove.node.right != null) q.add(new Pair(remove.node.right, remove.state + 1));

                // print item data
                if (remove.state == k) {
                    System.out.println(remove.node.data + " ");
                }


                currentLevelSize -= 1;
            }
        }
    }

    // print k Levels down - approach - 02 -> using height/level
    public static void KLevelsDownApproach2(Node node, int k) {
        if (node == null) return;

        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        KLevelsDownApproach2(node.left, k - 1);
        KLevelsDownApproach2(node.right, k - 1);
    }

    private static List<Node> nodeToRoot(Node node, int data) {
        if (node == null) return new ArrayList<Node>();
        if (node.data == data) {
            List<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        List<Node> lRes = nodeToRoot(node.left, data);
        if (lRes.size() > 0) {
            lRes.add(node);
            return lRes;
        }

        List<Node> rRes = nodeToRoot(node.right, data);
        if (rRes.size() > 0) {
            rRes.add(node);
            return rRes;
        }
        return new ArrayList<Node>();
    }

    // print k Levels down - approach - 02 -> using height/level
    public static void KLevelsDownWithBlockage(Node node, int k, Node blockage) {
        if (node == null || node == blockage) return;

        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        KLevelsDownWithBlockage(node.left, k - 1, blockage);
        KLevelsDownWithBlockage(node.right, k - 1, blockage);
    }

    public static void kDistanceAway(Node node, int data, int k) {
        List<Node> n2rp = nodeToRoot(node, data);
        Node blockage = null;
        for (int i = 0; i < n2rp.size(); i++) {
            Node current = n2rp.get(i);
            KLevelsDownWithBlockage(current, k, blockage);
            blockage = current;
            k--;
        }
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (sum + node.data >= lo && sum + node.data <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);

        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    // work in post-order
    public static Node createLeftCloneTree(Node node) {
        if (node == null) return null;

        Node leftChildNode = createLeftCloneTree(node.left);
        Node rightChildNode = createLeftCloneTree(node.right);

        Node myLeft = node.left;
        Node newNode = new Node(node.data, null, null);

        node.left = newNode;
        newNode.left = myLeft;
        return node;
    }

    // work in pre-order
    public static void createLeftCloneTreeAppr2(Node root, Node parent) {
        if (root == null) return;

        Node newNode = new Node(root.data, null, null);
        Node left = root.left;
        Node right = root.right;

        root.left = newNode;
        newNode.left = left;

        createLeftCloneTreeAppr2(left, newNode);
        createLeftCloneTreeAppr2(right, root);
    }

    public static Node transferFromLeftClonedTree(Node node) {
        if (node == null) return null;
        Node lcn = transferFromLeftClonedTree(node.left.left);
        Node rcn = transferFromLeftClonedTree(node.right);

        node.left = lcn;
        node.right = rcn;
        return node;
    }

    // approach -01 -> using parent node
    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) return;

        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        }

        if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    // approach - 02 -> no need of parent node
    public static void printSingleChildNodes(Node node) {
        if (node.left != null && node.right != null) {

            printSingleChildNodes(node.left);
            printSingleChildNodes(node.right);

        } else if (node.left != null) { // right is null
            // print left node data and call left node

            printSingleChildNodes(node.left);
            System.out.println(node.left.data);

        } else if (node.right != null) {
            // print right node data and call right node
            printSingleChildNodes(node.right);
            System.out.println(node.right.data);

        } else {
            // both are null
            return;
        }
    }

    // approach 01 -> removing the leaves first then traversing (preorder) -> no need for a return type
    // doesn't works if the root is a leaf node (there should be at least 1 node given in the tree)
    public static void removeLeaves01(Node node) {
        if (node == null) return;

        if (node.left != null) { // right child is null, hence check if the left child is a leaf node
            if (node.left.left == null && node.left.right == null)
                node.left = null;
        }

        if (node.right != null) { // left child is null, hence check if the right child is a leaf node
            if (node.right.left == null && node.right.right == null)
                node.right = null;
        }
        removeLeaves01(node.left); // traverse further left to remove leaf nodes
        removeLeaves01(node.right); // traverse further right to remove leaf nodes
    }

    // approach 02 -> removing the leaves after traversing (postorder) better
    public static Node removeLeaves02(Node node) {
        if (node == null) return null;

        if(node.left != null && node.right != null) { // both children are non-null hence traverse further
            node.left = removeLeaves02(node.left);
            node.right = removeLeaves02(node.right);
        } else if (node.left != null) {
            node.left = removeLeaves02(node.left); // right child is null, hence travel left and remove leaf nodes
        } else if(node.right != null) {
            node.right = removeLeaves02(node.right); // left child is null, hence travel right and remove leaf nodes
        } else {
            // both children of current node are null, hence this node is leaf -> set this node as null.
            node = null;
        }
        return node; // return current node after checking for leaf nodes.
    }

    static int tilt = 0;
    public static int tilt(Node node){ // return sum but impact on static tilt variable
        if(node == null) return 0;

        int lSum = tilt(node.left);
        int rSum = tilt(node.right);

        tilt += Math.abs(lSum-rSum);
        return lSum + rSum + node.data;
    }

    static int diameter = 0;
    public static int diameter(Node node) {// returns height but impact on static diameter variable
        if(node == null) return -1;
        int deepestNodeHeight = -1;
        int secondDeepestNodeHeight = -1;

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        deepestNodeHeight = Math.max(lHeight, rHeight);
        secondDeepestNodeHeight = Math.min(lHeight, rHeight);

        int candidateDiameter = deepestNodeHeight + secondDeepestNodeHeight + 2;

        if(candidateDiameter > diameter) {
            diameter = candidateDiameter;
        }

        return Math.max(lHeight, rHeight) + 1;
    }

    // approach 01
    public static boolean isBST01(Node node) {
        if(node == null) return true;

        // self check
        int lMax = max(node.left);
        int rMin = min(node.right);

        if(lMax > node.data || rMin < node.data) return false;

        return isBST01(node.left) && isBST01(node.right);
    }

    static class BSTPair {
        int min;
        int max;
        boolean isBST;

        public BSTPair() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.isBST = true;
        }
    }
    public static BSTPair isBST02(Node node) {
        if(node == null) return new BSTPair();

        BSTPair left = isBST02(node.left);
        BSTPair right = isBST02(node.right);

        boolean amIBst = node.data > left.max && node.data < right.min;

        BSTPair myResult = new BSTPair();
        myResult.min = Math.min(node.data, Math.min(left.min, right.min));
        myResult.max = Math.max(node.data, Math.max(left.max, right.max));
        myResult.isBST = amIBst && left.isBST && right.isBST;
        return myResult;
    }

    static class BalancedPair {
        int ht;
        boolean isBalanced;

        public BalancedPair() {
            this.ht = -1;
            this.isBalanced = true;
        }
    }
    // Difference in heights of subtrees should not be more than 1
    public static BalancedPair isBalanced(Node node) {
        if(node == null) return new BalancedPair();

        // left subtree height
        BalancedPair left = isBalanced(node.left);
        BalancedPair right = isBalanced(node.right);

        boolean factor = Math.abs(left.ht - right.ht) <= 1;

        BalancedPair mres = new BalancedPair();
        mres.ht = Math.max(left.ht, right.ht) + 1;
        mres.isBalanced = factor && left.isBalanced && right.isBalanced;
        return mres;
    }

    static class LargestSizeBSTPair {
        int min;
        int max;
        boolean isBST;
        int size;
        public LargestSizeBSTPair() {
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }

    private static int largestSize = 0;
    private static Node largestSizeNode = null;

    public static LargestSizeBSTPair largestBST(Node root) {
        if(root == null) return new LargestSizeBSTPair();

        LargestSizeBSTPair lst = largestBST(root.left);
        LargestSizeBSTPair rst = largestBST(root.right);

        boolean amIBST = root.data >= lst.max && root.data <= rst.min;

        LargestSizeBSTPair res = new LargestSizeBSTPair();
        res.min = Math.min(root.data, Math.min(lst.min, rst.min));
        res.max = Math.max(root.data, Math.max(lst.max, rst.max));
        res.isBST = lst.isBST && rst.isBST && amIBST;
        res.size = lst.size + rst.size + 1;

        if(res.isBST && res.size > largestSize) {
            largestSize = Math.max(largestSize, res.size);
            largestSizeNode = root;
        }

        return res;
    }
}
