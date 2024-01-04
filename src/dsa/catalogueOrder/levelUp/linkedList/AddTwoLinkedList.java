package dsa.catalogueOrder.levelUp.linkedList;

public class AddTwoLinkedList {

    private static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addLinkedList(reverseLL(l1), reverseLL(l2));
    }

    private static ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev.next = current;
            current = next;
        }

        return prev;
    }

    private static ListNode addLinkedList(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1 : l2;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        int carry = 0;

        while(temp1 != null || temp2 != null || carry != 0) {
            int sum = carry + (temp1 != null ? temp1.val : 0) + (temp2 != null ? temp2.val : 0);

            int ld = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(ld);
            itr.next = node;

            itr = itr.next;
            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
        }

        return reverseLL(dummy.next);
    }
}
