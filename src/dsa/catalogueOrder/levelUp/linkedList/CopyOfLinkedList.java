package dsa.catalogueOrder.levelUp.linkedList;

import java.util.HashMap;

public class CopyOfLinkedList {
    private static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Approach - 01 Using HashMap (Space Complexity is unoptimized)
    private static ListNode copyRandomList(ListNode head) {
        if(head == null) return null;

        ListNode current = head;

        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;

        HashMap<ListNode, ListNode> map = new HashMap<>();
        while(current != null) {
            ListNode node = new ListNode(current.val);
            itr.next = node;
            map.put(current, node);

            current=current.next;
            itr = itr.next;
        }

        ListNode headCopy = dummy.next;
        itr = headCopy;
        current = head;

        while(current != null) {
            itr.random = map.get(current.random);

            current = current.next;
            itr = itr.next;
        }

        return headCopy;
    }


    // Approach - 02
    private static ListNode copyRandomListWithoutExtraSpace(ListNode head) {
        return null;
    }

}
