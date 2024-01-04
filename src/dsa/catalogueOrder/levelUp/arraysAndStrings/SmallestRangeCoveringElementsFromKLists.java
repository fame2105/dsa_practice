package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.List;
import java.util.PriorityQueue;

// 632:  https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
public class SmallestRangeCoveringElementsFromKLists {
    private class Pair {
        int listIdx;
        int valIdx;
        int val;
        Pair(int listIdx, int valIdx, int val) {
            this.listIdx = listIdx;
            this.valIdx = valIdx;
            this.val = val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> pair1.val - pair2.val);

        int start = (int)1e9;
        int end = (int)-1e9;

        for(int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);

            start = Math.min(start, val);
            end = Math.max(end, val);

            pq.add(new Pair(i, 0, val));
        }

        int[] ans = new int[2];
        ans[0] = start;
        ans[1] = end;

        int rangeLength = end - start;

        while(pq.size() > 0) {
            Pair smallestPair = pq.remove();

            int newValIdx = smallestPair.valIdx + 1;
            int listIdx = smallestPair.listIdx;

            if(newValIdx >= nums.get(listIdx).size()) break;

            int newVal = nums.get(listIdx).get(newValIdx);

            pq.add(new Pair(listIdx, newValIdx, newVal));

            start = pq.peek().val;
            end = Math.max(end, newVal);

            if(end - start < rangeLength) {
                ans[0] = start;
                ans[1] = end;
                rangeLength = end - start;
            }
        }

        return ans;
    }
}
