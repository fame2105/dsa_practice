package dsa.catalogueOrder.foundation.linkedList;

import dsa.utility.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    // Assume you are given reverse linked Lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode result = new ListNode(-1);
        ListNode resultItr = result;
        int carry = 0;

        while (i != null || j != null || carry != 0) {
            int iVal = i == null ? 0 : i.val;
            i = i == null ? null : i.next;

            int jVal = j == null ? 0 : j.val;
            j = j == null ? null : j.next;

            int sum = iVal + jVal + carry;

            carry = sum / 10;
            int val = sum % 10;

            ListNode node = new ListNode(val);
            resultItr.next = node;
            resultItr = node;
        }

        return result.next;
    }

    public ListNode addRecursive(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(-1);
//        int carry = additionHelper(head1, head1.size, head2, head2.size, result);
        return null;
    }

    private static int additionHelper(ListNode head1, int size1, ListNode head2, int size2) {
        return 0;
    }
}
