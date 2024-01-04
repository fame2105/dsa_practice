package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Question link : https://leetcode.com/problems/insert-delete-getrandom-o1/description/

public class _380_InsertDeleteGetRandom {
    class RandomizedSet {
        Random random;
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> numIdx; // val : idx

        public RandomizedSet() {
            random = new Random();
            nums = new ArrayList<>();
            numIdx = new HashMap<>();
        }

        public boolean insert(int val) {
            if (numIdx.containsKey(val) == true) { // trying to add a duplicate value
                return false;
            }

            numIdx.put(val, nums.size());
            nums.add(val);
            return true;
        }

        // This is easy but tricky... use pen and paper to understand how to remove an element in O(1) time complexity
        public boolean remove(int val) {
            if (numIdx.containsKey(val) == false) { // trying to remove a value which is not present
                return false;
            }

            int valIdx = numIdx.get(val);
            int lastIdx = nums.size() - 1;
            int lastVal = nums.get(lastIdx);
            if (valIdx != lastIdx) {
                nums.set(valIdx, lastVal);
                nums.remove(lastIdx);
                numIdx.put(lastVal, valIdx);
                numIdx.remove(val);
            } else {
                nums.remove(lastIdx);
                numIdx.remove(lastVal);
            }
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
