package dsa.catalogueOrder.competitive.segmentTree;

// get max value in an interval
public class SegmentTree {
    int[] tree;
    int[] arr;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        tree = new int[4 * arr.length];
        buildSegmentTree(1, 0, arr.length - 1);
    }

    private void buildSegmentTree(int nodeNumber, int start, int end) {
        if(start == end) {
            tree[start] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        int leftNodeNumber = 2 * nodeNumber;
        int rightNodeNumber = 2 * nodeNumber + 1;
        buildSegmentTree(leftNodeNumber, start, mid);
        buildSegmentTree(rightNodeNumber + 1, mid + 1, end);

        tree[nodeNumber] = Math.max(tree[leftNodeNumber], tree[rightNodeNumber]);
    }


}
