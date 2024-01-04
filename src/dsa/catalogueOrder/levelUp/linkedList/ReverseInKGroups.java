package dsa.catalogueOrder.levelUp.linkedList;

public class ReverseInKGroups {

    private static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) return head;

        ListNode oh = null;
        ListNode ot = null;

        int len = length(head);
        ListNode current = head;
        while(len >= k) {
            int counter = 0;
            while(current != null && counter < k) {
                ListNode forw = current.next;
                current.next = null;
                addFirst(current);

                counter++;
                current = forw;
            }

            if(oh == null) {
                oh = tempHead;
                ot = tempTail;
            } else {
                ot.next = tempHead;
                ot = tempTail;
            }

            len -= k;
            tempHead = tempTail = null;
        }

        ot.next = current;
        return oh;
    }

    private static int length(ListNode head) {
        if(head == null) return 0;
        int counter = 0;
        ListNode temp = head;
        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    private static ListNode tempHead = null;
    private static ListNode tempTail = null;
    private static void addFirst(ListNode node) {
        if(node == null) {
            return;
        }

        if(tempHead == null) {
            tempHead = tempTail = node;
            return;
        }

        node.next = tempHead;
        tempHead = node;
    }
}
