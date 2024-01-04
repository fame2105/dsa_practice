package dsa.catalogueOrder.levelUp.linkedList;

public class MergeKSortedListDevideAndConquer {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length-1);

    }

    private static ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        if(lo > hi) return null;
        if(lo == hi) return lists[lo];

        int mid = (lo + hi) / 2;

        ListNode left = mergeKLists(lists, lo, mid);
        ListNode right = mergeKLists(lists, mid+1, hi);

        return mergeTwoSortedLists(left, right);
    }

    private static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1: l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        ListNode head1 = l1, head2 = l2;

        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
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
}
