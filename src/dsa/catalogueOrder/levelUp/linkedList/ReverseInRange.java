package dsa.catalogueOrder.levelUp.linkedList;

public class ReverseInRange {
    private static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode tempHead = null;
    private static ListNode tempTail = null;

    private static void addFirst(ListNode node) {
        if(tempHead == null) {
            tempHead = tempTail = node;
        } else {
            node.next = tempHead;
            tempHead = node;
        }
    }

    public static ListNode reverseInRange(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        ListNode current = head;
        int idx = 1;
        while(current != null) {
            if(idx == left) {
                for(int i = 0; i <= (right - left); i++) {
                    ListNode forw = current.next;
                    current.next = null;
                    addFirst(current);
                    current = forw;
                }
                break;
            } else {
                itr.next = current;
                itr = itr.next;
                current = current.next;
                idx++;
            }
        }

        itr.next = tempHead;
        tempTail.next = current;
        return dummy.next;
    }
}
