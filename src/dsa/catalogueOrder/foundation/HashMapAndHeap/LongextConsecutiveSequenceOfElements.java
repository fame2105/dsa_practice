package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.HashMap;
import java.util.Scanner;

public class LongextConsecutiveSequenceOfElements {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        printLongestConsecutiveSequence(a);

    }

    private static void printLongestConsecutiveSequence(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Put all values in Map as true
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        // seperate out those values in map those cannot be the starting point of the sequence
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key - 1)) {
                map.put(key, false);
            }
        }

        int maxSequenceLength = 0;
        int maxSequenceStartPoint = 0;
        for (int key : nums) {
            if (map.get(key) == true) {
                int currentStartingPoint = key;
                int currentSequenceLength = 1;

                while (map.containsKey(currentStartingPoint + currentSequenceLength) == true) {
                    currentSequenceLength += 1;
                }

                if (currentSequenceLength > maxSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                    maxSequenceStartPoint = currentStartingPoint;
                }
                map.put(key, false);
            }
        }

        // print max Sequence
        for (int i = maxSequenceStartPoint; i < maxSequenceStartPoint + maxSequenceLength; i++)
            System.out.println(i);
    }
}
