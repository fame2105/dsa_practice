package dsa.catalogueOrder.levelUp.linkedList;

public class LinkedList {
    private static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 1. Iterative
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static ListNode reverseRecursive(ListNode head) {

        return null;
    }

    // 2.
    public static ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 3.
    public static boolean isPalindrome(ListNode head) {
        ListNode head1 = head;
        ListNode midNode = midNode(head);
        ListNode head2 = midNode.next;
        midNode.next = null;
        head2 = reverseIterative(head2);
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                head1 = head1.next;
                head2 = head2.next;
            } else {
                return false;
            }
        }
        return true;
    }

    // 4.
    public static void fold(ListNode head) {
        ListNode head1 = head;
        ListNode midNode = midNode(head);
        ListNode head2 = midNode.next;
        midNode.next = null;
        head2 = reverseIterative(head2);

        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }

    public static void unfold(ListNode head) {
        ListNode fh = head; // first head
        ListNode fp = fh; // first previous

        ListNode sh = head.next; // second head
        ListNode sp = sh; // second previous

        while (sp != null && sp.next != null) {
            ListNode f = sp.next; // forward

            // Links
            fp.next = f;
            sp.next = f.next;

            // move
            fp = fp.next;
            sp = sp.next;
        }
        fp.next = null;

        sp = reverseIterative(sh);
        fp.next = sp;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 != null) return l1 != null ? l1 : l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode temp = null;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }

            prev = prev.next;
        }

        prev.next = head1 != null ? head1 : head2;

        return dummy.next;
    }

    // n will always be a valid values -> 1 based index
    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        if(head.next == null) return null;

        ListNode fast = head;
        for(int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if(fast == null) { // if fast == null that would mean given list.size() == n, therefore remove first node;
            return head.next;
        }

        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    public static ListNode CycleNode(ListNode head) {
        if(head == null || head.next == null) return head; // No cycle in case of 0 or only 1 node

        ListNode slow = head, fast = head;
        boolean cycleExists = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow =slow.next;

            if(slow == fast) break;
        }

        if(slow != fast) return null; // cycle does not exists

        slow = head; // reset slow pointer position to start of the linked list

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode dummy = new ListNode(-1);

        ListNode current = head, itr = dummy;
        itr.next = head;
        while(current != null) {
            if(itr.val != current.val) {
                itr.next = current;
                itr = itr.next;
            }
            current = current.next;
        }
        itr.next = null;
        return dummy.next;
    }

    public static ListNode removeAllDuplicates(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy, current = head.next;
        itr.next = head;
        while(current != null) {
            boolean flag = false;
            while(current!= null && itr.next.val == current.val) {
                flag = true;
                current = current.next;
            }

            if(flag == true) {
                itr.next = current;
            } else {
                itr = itr.next;
            }

            if(current != null) current = current.next;
        }

        return dummy.next;
    }

    private static void driver() {

    }

    public static void main(String[] args) {
        driver();
    }


}
