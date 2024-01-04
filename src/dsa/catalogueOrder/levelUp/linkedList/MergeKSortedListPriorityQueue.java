package dsa.catalogueOrder.levelUp.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedListPriorityQueue {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode head : lists) if(head != null) q.add(head);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(q.size() > 0) {
            ListNode node  = q.remove();
            prev.next = node;

            if(node.next != null) q.add(node.next);

            prev = prev.next;
        }

        return dummy.next;
    }
}
