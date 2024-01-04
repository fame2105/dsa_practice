package dsa.catalogueOrder.levelUp.linkedList;

public class SeggregateLinkedList {
    private static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oHead = new ListNode(-1);
        ListNode oTail = oHead;

        ListNode eHead = new ListNode(-1);
        ListNode eTail = eHead;

        ListNode current = head;
        while (current != null) {
            if (current.val % 2 == 0) {
                eTail.next = current;
                eTail = eTail.next;
            } else {
                oTail.next = current;
                oTail = oTail.next;
            }

            current = current.next;
        }
        eTail.next = oHead.next; // attach end of even tail to start of odd head
        oTail.next = null; // make sure to cut the link of odd Linked -> otherwise it forms a cycle;

        return eHead.next;
    }

    public static ListNode segregate01_SwappingNodes(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode zeroHead = new ListNode(-1);
        ListNode zeroTail = zeroHead;

        ListNode oneHead = new ListNode(-1);
        ListNode oneTail = oneHead;

        ListNode current = head;

        while (current != null) {
            if (current.val == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else {
                oneTail.next = current;
                oneTail = oneTail.next;
            }

            current = current.next;
        }
        zeroTail.next = oneHead.next; // attach the end of zero linkedList to the start of one LinkedList
        oneTail.next = null; // cut the link of one Linked -> otherwise it forms a cycle;
        return zeroHead.next;
    }

    public static ListNode segregate01_SwappingData(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode i = head;
        ListNode j = head;

        while (i != null) {
            if (i.val == 1) {
                i = i.next;
            } else {
                // swap data
                int temp = i.val;
                i.val = j.val;
                j.val = temp;

                i = i.next;
                j = j.next;
            }
        }

        return head;
    }

    public static ListNode segregate012_SwappingNodes(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode zeroHead = new ListNode(-1);
        ListNode zeroTail = zeroHead;

        ListNode oneHead = new ListNode(-1);
        ListNode oneTail = oneHead;

        ListNode twoHead = new ListNode(-1);
        ListNode twoTail = twoHead;

        ListNode current = head;
        while (current != null) {
            if (current.val == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else if (current.val == 1) {
                oneTail.next = current;
                oneTail = oneTail.next;
            } else {
                twoTail.next = current;
                twoTail = twoTail.next;
            }

            current = current.next;
        }

        // attach links in order -> first for 2 , then for 1 then for 0
        twoTail.next = null;
        oneTail.next = twoHead.next; // this line should come first -> otherwise we will we get wrong output for a linked list containing all 2's
        zeroTail.next = oneHead.next;

        return zeroHead.next;
    }

    public static ListNode segregate012_SwappingData(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode i = head;
        ListNode j = head;
        ListNode k = head;

        while (i != null) {
            if (i.val == 2) {
                i = i.next;
            } else if (i.val == 1) {
                int temp = i.val;
                i.val = j.val;
                j.val = temp;

                i = i.next;
                j = j.next;
            } else {
                int temp = i.val;
                i.val = j.val;
                j.val = temp;

                temp = j.val;
                j.val = k.val;
                k.val = temp;

                i = i.next;
                j = j.next;
                k = k.next;
            }
        }
        return head;
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode lastIndexNode = segregateOnLastIndex_getTail_helper(head);
        ListNode smallerHead = new ListNode(-1);
        ListNode smallerTail = smallerHead;

        ListNode largerHead = new ListNode(-1);
        ListNode largerTail = largerHead;

        ListNode current = head;

        while (current != null) {
            if (current.val <= lastIndexNode.val) {
                smallerTail.next = current;
                smallerTail = smallerTail.next;
            } else {
                largerTail.next = current;
                largerTail = largerTail.next;
            }
            current = current.next;
        }

        smallerTail.next = largerHead.next; // connect smaller elements linkedList to larger elements LinkedList
        largerTail.next = null; // this is necessary to avoid linkedList from becoming circular.

        return smallerHead.next;

    }

    private static ListNode segregateOnLastIndex_getTail_helper(ListNode head) {
        if (head == null) return null;

        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }

    public static ListNode segregateOnPivotIndex(ListNode head, int pivotIdx) {
        if (head == null || head.next == null) return head;

        int idx = 0;
        ListNode pivotNode = null;
        ListNode current = head;
        while (current != null) {
            if (idx == pivotIdx) {
                pivotNode = current;
                break;
            }

            idx++;
            current = current.next;
        }

        ListNode smallerHead = new ListNode(-1);
        ListNode smallerTail = smallerHead;

        ListNode largerHead = new ListNode(-1);
        ListNode largerTail = largerHead;

        current = head;

        while (current != null) {
            if (current == pivotNode) {
                current = current.next;
                continue;
            } else if (current.val <= pivotNode.val) {
                smallerTail.next = current;
                smallerTail = smallerTail.next;
            } else {
                largerTail.next = current;
                largerTail = largerTail.next;
            }
            current = current.next;
        }

        smallerTail.next = pivotNode;
        pivotNode.next = largerHead.next;
        largerTail.next = null;

        return smallerHead.next;
    }
}
