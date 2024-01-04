package dsa.catalogueOrder.foundation.genericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GenericTree<T> {

    public static void main(String[] args) {
        GenericTree<Integer> gt = new GenericTree<>();
        gt.driver();
    }

    public void driver() {
        Integer[] data = {10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null, null, 40, 100, null, null, null};

        GTNode root = this.construct(data);

        System.out.println("Displaying the generic Tree :");
        this.display(root);

        /*System.out.println("--------------------------------------------------------");

        int size = size(root);
        System.out.println("Size of generic tree = " + size);

        System.out.println("--------------------------------------------------------");

        int max = max(root);
        System.out.println("Max in this generic tree = " + max);

        System.out.println("--------------------------------------------------------");

        int min = min(root);
        System.out.println("Min in this generic tree = " + min);

        System.out.println("--------------------------------------------------------");

        int height = heightOnTheBasisOfEdge(root);
        System.out.println("height in this generic tree = " + height);

        System.out.println("--------------------------------------------------------");

        traversals(root);

        System.out.println("--------------------------------------------------------");

        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);

        System.out.println("--------------------------------------------------------");

        System.out.println("Level Order Line Wise Traversal using Approach 1");
        levelOrderLineWiseTwoQueuesApproach1(root);

        System.out.println("--------------------------------------------------------");

        System.out.println("Level Order Line Wise Traversal using Approach 2");
        levelOrderLineWiseDelimiterApproach2(root);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Level Order Line Wise Traversal using Approach 3");
        levelOrderLineWiseSizeApproach3(root);

        System.out.println("--------------------------------------------------------");

        System.out.println("Level Order Zig Zag Traversal using Approach 1");
        levelOrderTraversalZigzagApproach1(root);

        System.out.println("--------------------------------------------------------");

        System.out.println("Level Order Zig Zag Traversal using Approach 2");
        levelOrderTraversalZigzagApproach2(root);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Mirror Tree");
        mirrorTree(root);
        this.display(root);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Linearize Generic Tree");
        removeLeafNodes(root);
        this.display(root);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Remove Leaf Nodes");
        linearizeGenericTree(root);
        this.display(root);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Present in Generic Tree");
        boolean result = findInGenericTree(root, 110);
        System.out.println(result);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Node to Root Path");
        List<Integer> result = nodeToRootPath(root, 120);
        System.out.println(result);*/

        /*System.out.println("--------------------------------------------------------");

        System.out.println("Distance between Nodes of a Generic Tree");
        int result = distanceBetweenNodes(root, 60, 120);
        System.out.println(result);*/

        System.out.println("--------------------------------------------------------");

        System.out.println("Lowest Common Ancestor of 60 and 120 is : " + lowestCommonAncestor(root, 60, 120));

        System.out.println("--------------------------------------------------------");
        System.out.println("Is the tree symmetric : " + isSymmetric(root));

        System.out.println("--------------------------------------------------------");
        System.out.println("Tree Sum");
        System.out.println(treeSum(root));
    }

    public GTNode construct(Integer[] arr) {
        GTNode root = null;
        Stack<GTNode> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            Integer data = arr[i];
            if (data != null) { // if data is not null then create a node out of this data and figure out if this node will be root or child of some other node
                GTNode newNode = new GTNode(data);

                if (st.isEmpty()) { // this node will become root if it is the very first node.
                    root = newNode;
                } else {
                    st.peek().children.add(newNode); // this node will become children of the node kept at the top of the stack
                }
                st.push(newNode); // push this node on the stack, because there could be other nodes that could be children of this node
            } else { // we encountered null (a marker which means that subtree of this node is traversed and should be removed from the stack)
                st.pop();
            }
        }
        return root;
    }

    // doesn't need base case because never enters invalid case -> dry run for more details
    public void display(GTNode<T> root) {
        // string for printing current node data
        String str = "[" + root.data + "] -> ";

        // attach immediate children data to current
        for (GTNode child : root.children) {
            str = str + child.data + ", ";
        }

        // print current and immediate children data
        System.out.println(str + "_");

        // print data for all children Nodes
        for (GTNode child : root.children) {
            display(child);
        }
    }

    // return total number of nodes in the generic tree
    public int size(GTNode<T> node) {
        int count = 0;

        for (GTNode child : node.children) {
            count += size(child);
        }

        return count + 1;
    }

    // this will work only for integer data
    public int max(GTNode<T> node) {
        int max = Integer.MIN_VALUE;
        for (GTNode child : node.children) {
            max = Math.max(max, max(child));
        }
        return Math.max(max, (Integer) node.data);
    }

    // this will work only for integer data
    public int min(GTNode<T> node) {

        int min = Integer.MAX_VALUE;
        for (GTNode child : node.children) {
            min = Math.min(min, min(child));
        }
        return Math.min(min, (Integer) node.data);
    }

    public int heightOnTheBasisOfEdge(GTNode<T> node) {
        if (node.children.isEmpty()) return 0;

        int ht = 0;
        for (GTNode child : node.children) {
            ht = Math.max(ht, heightOnTheBasisOfEdge(child));
        }
        return ht + 1;
    }

    public int heightOnTheBasisOfNode(GTNode<T> node) {
        return 0;
    }

    /**
     * Traversal Algo:
     * just after entering into function/level -> node pre
     * just before entering into recursive call -> edge pre
     * just after coming out of recursive call -> edge post
     * just before leaving/completing the function/level-> node post
     */
    public void traversals(GTNode<T> node) {
        // node pre
        System.out.println("Node Pre " + node.data);

        for (GTNode child : node.children) {
            // before call -> edge pre
            System.out.println("Edge Pre " + node.data + "--" + child.data);

            traversals(child);

            // after call -> edge post
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        // node post
        System.out.println("Node Post " + node.data);
    }

    public void levelOrderTraversal(GTNode<T> node) {
        Queue<GTNode<T>> q = new ArrayDeque<>();

        q.add(node);// add root node to mainQ

        while (!q.isEmpty()) {
            // get + remove
            GTNode<T> current = q.remove();

            // print
            System.out.print(current.data + " ");

            // push children of current
            for (GTNode child : current.children) {
                q.add(child);
            }
        }
        System.out.println(".");
    }

    // Approach - 01 -> using 2 queues
    public void levelOrderLineWiseTwoQueuesApproach1(GTNode<T> node) {
        Queue<GTNode<T>> mainQ = new ArrayDeque<>();
        Queue<GTNode<T>> childQ = new ArrayDeque<>();

        mainQ.add(node); // add root node to mainQ

        while (!mainQ.isEmpty()) {
            GTNode<T> current = mainQ.remove();

            System.out.print(current.data + " ");

            // push children of current to childQ
            for (GTNode child : current.children) {
                childQ.add(child);
            }

            if (mainQ.isEmpty()) {
                // change Line
                System.out.println();

                // swap childQ and mainQ
                Queue<GTNode<T>> temp = mainQ;
                mainQ = childQ;
                childQ = temp;
            }
        }
    }

    // Approach - 02 -> using single Queue and a delimiter
    public void levelOrderLineWiseDelimiterApproach2(GTNode<T> node) {
        Queue<GTNode<T>> q = new LinkedList<>(); // using linkedList as Queue since ArrayDequeue does not allow adding null values

        q.add(node); // add root node to mainQ
        q.add(null);

        while (!q.isEmpty()) {
            GTNode<T> current = q.remove();
            if (current != null) {
                System.out.print(current.data + " ");

                // push children of current to q
                for (GTNode child : current.children) {
                    q.add(child);
                }
            } else {
                // do not add null if there are no more elements/child nodes present in the q to process
                if (!q.isEmpty()) {
                    System.out.println();
                    q.add(null);
                }
            }
        }
    }

    // Approach - 03 -> using single Queue and number of elements added at each level
    public void levelOrderLineWiseSizeApproach3(GTNode<T> node) {
        Queue<GTNode<T>> q = new LinkedList<>(); // using linkedList as Queue since ArrayDequeue does not allow adding null values

        q.add(node); // add root node to mainQ

        while (!q.isEmpty()) {

            int currentLevelSize = q.size();

            // process nodes of current level in the queue
            for (int i = 1; i <= currentLevelSize; i++) {
                GTNode<T> curr = q.remove();
                System.out.print(curr.data + " ");

                // add child nodes of current level nodes to queue
                for (GTNode<T> child : curr.children) {
                    q.add(child);
                }
            }

            // this level completed
            System.out.println();
        }
    }

    //  better approach
    public void levelOrderTraversalZigzagApproach1(GTNode<T> node) {
        Queue<GTNode<T>> q = new LinkedList<>(); // using linkedList as Queue since ArrayDequeue does not allow adding null values
        Stack<GTNode<T>> st = new Stack<>();
        q.add(node); // add root node to mainQ

        /**
         * if level is odd, simply print the node values as it is and add their children in the queue,
         * if level is even then add the node values to stack and add their children into queue, subsequently..empty the stack before toggling level value
         */
        int level = 1;
        while (!q.isEmpty()) {

            int currentLevelSize = q.size();

            // process nodes of current level in the queue
            for (int i = 1; i <= currentLevelSize; i++) {
                GTNode<T> curr = q.remove();

                if (level % 2 == 0) {
                    st.add(curr);
                } else {
                    System.out.print(curr.data + " ");
                }

                // add child nodes of current level nodes to queue
                for (GTNode<T> child : curr.children) {
                    q.add(child);
                }
            }

            if (!st.isEmpty()) {
                while (!st.isEmpty()) {
                    System.out.print(st.pop().data + " ");
                }
            }

            // this level processing is completed -> change line and increase level
            System.out.println();
            level += 1;
        }
    }

    // using double stack
    public void levelOrderTraversalZigzagApproach2(GTNode<T> node) {
        Stack<GTNode<T>> mainStack = new Stack<>();
        Stack<GTNode<T>> childStack = new Stack<>();

        mainStack.push(node);
        int level = 1;
        while (!mainStack.isEmpty()) {

            while (!mainStack.isEmpty()) {
                GTNode<T> current = mainStack.pop();
                System.out.print(current.data + " ");

                if (level % 2 == 0) { // even level
                    // add children nodes right to left
                    for (int i = current.children.size() - 1; i >= 0; i--)
                        childStack.push(current.children.get(i));

                } else { // odd level
                    // add children nodes left to right
                    for (GTNode<T> child : current.children)
                        childStack.push(child);
                }
            }

            // change line
            System.out.println();
            level += 1;
            // swap mainStack and childStack
            Stack<GTNode<T>> temp = mainStack;
            mainStack = childStack;
            childStack = temp;
        }
    }

    public void mirrorTree(GTNode<T> node) {
        for (GTNode child : node.children) {
            mirrorTree(child);
        }
        int left = 0;
        int right = node.children.size() - 1;

        while (left < right) {
            GTNode temp = node.children.get(left);
            node.children.set(left, node.children.get(right));
            node.children.set(right, temp);
            left++;
            right--;
        }
    }

    public void removeLeafNodes(GTNode<T> node) { // work on its complexity
        for (int i = node.children.size() - 1; i >= 0; i--) {
            if (node.children.get(i).children.isEmpty()) {
                // remove this node at this level
                node.children.remove(i);
            }
        }

        for (GTNode child : node.children) {
            removeLeafNodes(child);
        }
    }

    public void linearizeGenericTree(GTNode<T> node) {
        for (GTNode child : node.children)
            linearizeGenericTree(child);

        for (int i = node.children.size() - 2; i >= 0; i--) {
            GTNode last = node.children.get(i + 1);
            GTNode current = node.children.get(i);

            node.children.remove(i + 1);
            GTNode tail = getTail(current);
            tail.children.add(last);
        }
    }

    private GTNode getTail(GTNode<T> node) {
        while (!node.children.isEmpty()) {
            node = node.children.get(0);
        }
        return node;
    }

    private boolean findInGenericTree(GTNode<Integer> node, int data) {
        if (node.data == data) return true;

        boolean result = false;
        for (GTNode<Integer> child : node.children) {
            result = findInGenericTree(child, data);

            if (result) return true;
        }
        return false;
    }

    private List<Integer> nodeToRootPath(GTNode<Integer> node, int data) {
        if (node.data == data) {
            List<Integer> list = new ArrayList<>();
            list.add(data);
            return list;
        }

        List<Integer> list = null;
        for (GTNode<Integer> child : node.children) {
            list = nodeToRootPath(child, data);
            if (list != null) {
                list.add(node.data);
                return list;
            }
        }
        return list;
    }

    public int lowestCommonAncestor(GTNode<Integer> node, int data1, int data2) {
        // node to root path for data1
        List<Integer> nodeToRootPathData1 = nodeToRootPath(node, data1);

        // node to root path for data1
        List<Integer> nodeToRootPathData2 = nodeToRootPath(node, data2);

        int i = nodeToRootPathData1.size() - 1;
        int j = nodeToRootPathData2.size() - 1;

        int result = -1;
        while (i >= 0 && j >= 0 && nodeToRootPathData1.get(i) == nodeToRootPathData2.get(j)) {
            result = nodeToRootPathData1.get(i);
            i--;
            j--;
        }
        return result;
    }

    // Edge distance
    public int distanceBetweenNodes(GTNode<Integer> node, int data1, int data2) {
        // node to root path for data1
        List<Integer> nodeToRootPathData1 = nodeToRootPath(node, data1);

        // node to root path for data1
        List<Integer> nodeToRootPathData2 = nodeToRootPath(node, data2);

        int i = nodeToRootPathData1.size() - 1;
        int j = nodeToRootPathData2.size() - 1;

        //  distance = (i + 1) + (j + 1)
        while (i >= 0 && j >= 0 && nodeToRootPathData1.get(i) == nodeToRootPathData2.get(j)) {
            i--;
            j--;
        }
        return i + 1 + j + 1;
    }

    // not concerned with data, just the shape of the tree should be same .. every node should have same number of children in order to have similar shape
    public boolean areSimilar(GTNode<T> node1, GTNode<T> node2) {
        if (node1.children.size() != node2.children.size()) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < node1.children.size(); i++) {
            result = areSimilar(node1.children.get(i), node2.children.get(i));
            if (result == false) return false;
        }
        return result;
    }

    // not concerned with data, just the shape of the tree should mirror images of each other... tree 1 from left and tree2 from right should be equal
    public boolean areMirror(GTNode<T> node1, GTNode<T> node2) {
        if (node1.children.size() != node2.children.size()) return false;

        for (int i = 0; i < node1.children.size(); i++) {
            // Node from front for node1
            GTNode<T> childNode1 = node1.children.get(i);

            // node from backwards for node2
            GTNode<T> childNode2 = node2.children.get(node2.children.size() - 1 - i);

            boolean result = areMirror(childNode1, childNode2);
            if (result == false) return false;
        }

        return true;
    }

    public boolean isSymmetric(GTNode<T> node) {
        return areMirror(node, node);
    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = 0;
    static int size = 0;

    // Either use global variables or wrap entire logic in a class using fields and methods
    public void multisolver(GTNode<Integer> node, int depth) {
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        size += 1;

        for (GTNode child : node.children) {
            multisolver(child, depth + 1);
        }
    }

    static GTNode predecessor;
    static GTNode successor;
    static int state = 0;

    public void predecessorAndSuccessor(GTNode<T> node, T data) {
        if (state == 0) {
            if (node.data == data) state += 1;
            else predecessor = node;
        } else if (state == 1) {
            successor = node;
            state += 1;
            return;
        }

        for (GTNode child : node.children) {
            if (state < 2) { // when state == 2 then that means we have already set the predecessor and successor
                predecessorAndSuccessor(child, data);
            }
        }
    }

    static Integer ciel = Integer.MAX_VALUE; // smallest among all values larger than data
    static Integer floor = Integer.MIN_VALUE; // Largest among all values smaller than data

    public void ceilAndFloor(GTNode<Integer> node, Integer data) {
        if (node.data > data) {
            // potential ciel value
            ciel = Math.min(ciel, node.data);
        }

        if (node.data < data) {
            // potential floor value
            floor = Math.max(floor, node.data);

        }

        for (GTNode child : node.children) {
            ceilAndFloor(child, data);
        }
    }

    public int KthLargest(GTNode node, int k) {
        int data = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, data);
             data = floor;
             // reset floor
            floor = Integer.MIN_VALUE;
        }
        return data;
    }

    private static int maxSumNode = 0;
    private static int maxSum = 0;
    private int maxSumSubtree(GTNode<Integer> node) {
        int sum = node.data;
        for(GTNode<Integer> child : node.children) {
            sum += maxSumSubtree(child);
        }
        if(sum > maxSum) {
            maxSumNode = node.data;
            maxSum = sum;
        }
        return sum;
    }

    private int treeSum(GTNode<Integer> node) {
        int sum = node.data;
        for(GTNode<Integer> child : node.children) {
            sum += treeSum(child);
        }

        System.out.println(node.data + " " + sum);
        return sum;
    }

}
