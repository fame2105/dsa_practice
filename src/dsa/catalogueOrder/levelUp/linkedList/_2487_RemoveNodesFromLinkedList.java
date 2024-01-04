package dsa.catalogueOrder.levelUp.linkedList;

// https://leetcode.com/contest/weekly-contest-321/problems/remove-nodes-from-linked-list/
public class _2487_RemoveNodesFromLinkedList {
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
  }
    public static ListNode removeNodes(ListNode head) {
        ListNode rev = reverse(head);
        ListNode curr = rev;

        while(curr != null && curr.next != null) {
            while(curr.next != null && curr.val > curr.next.val)
                curr.next = curr.next.next;

            curr = curr.next;
        }

        ListNode ans = reverse(rev);
        return ans;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
