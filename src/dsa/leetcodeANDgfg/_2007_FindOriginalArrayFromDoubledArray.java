package dsa.leetcodeANDgfg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-original-array-from-doubled-array/

/**
 * Approach :
 * 1. If changed is a doubled array, you should be able to delete elements and their doubled values until the array is empty.
 * 2. Which element is guaranteed to not be a doubled value? It is the smallest element.
 * 3. After removing the smallest element and its double from changed, is there another number that is guaranteed to not be a doubled value?
 */
public class _2007_FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(changed);

        for(int num : changed) {
            if(q.size() > 0 && q.peek() == num) {
                q.poll();
            } else {
                q.offer(num * 2);
                list.add(num);
            }
        }

        return q.size() > 0 ? new int[0] : list.stream().mapToInt(i -> i).toArray();
    }
}
