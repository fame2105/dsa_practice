package dsa.leetcodeANDgfg;

import java.util.ArrayList;

public class _109_ConvertSortedListToBST {


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public class TreeNode {
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

    /**
     * Approach : 01
     * Find mid Node of the given linked list every time we construct a new Node
     * (We would require to traverse half the list to find mid node every time
     *
     * 1. We know middle node will be our root , so we will calculate middle using findMiddle()
     * 2. We should also track prev of middle to mark the end of first list before middle node.
     * 3. Now we have two lists -
     * 	  list1:  [head....middle_prev]
     *    list2: [middle_next.....lastnode]
     * 4. middle is the root.
     * 5. put list1 in left of root and list2 in right of root.
     * 6. Repeat the process from beginning for list1 and list2.
     */

    /**
     * Approach : 02
     * Exactly similar to Approach 01 but convert linked list to ArrayList<Integer> and make BST using ArrayList
     *
     * it is a costant time operation to reach midNode in a BST using idx mid = (0 + arrayList.size() - 1) / 2
     */

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return constructBST(list, 0, list.size() - 1);
    }

    private TreeNode constructBST(ArrayList<Integer> list, int left, int right) {
        if(left > right) return null;

        int mid = (left + right)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = constructBST(list, left, mid-1);
        node.right = constructBST(list, mid+1, right);

        return node;
    }

}
