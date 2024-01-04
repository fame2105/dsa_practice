package dsa.leetcodeANDgfg;

import java.util.*;

public class _381_InsertDeleteGetRandomDuplicateAllowed {
    private ArrayList<Integer> nums;
    private HashMap<Integer, Set<Integer>> map;
    java.util.Random random = new java.util.Random();

    public _381_InsertDeleteGetRandomDuplicateAllowed() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) map.put(val, new LinkedHashSet<>());
        map.get(val).add(nums.size());
        nums.add(val);
        System.out.println("After Insertion of " + val + " --- Map = " + map + " and List = " + nums);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if(map.containsKey(val) == false || map.get(val).size() == 0) {
            return false;
        }

        int valIdx = map.get(val).iterator().next();
        map.get(val).remove(valIdx);
        int lastVal = nums.get(nums.size() - 1);
        nums.set(valIdx, lastVal);
        map.get(lastVal).add(valIdx);
        map.get(lastVal).remove(nums.size() - 1);

        nums.remove(nums.size() - 1);

        System.out.println("After Deletion of " + val + " --- Map = " + map + " and List = " + nums);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        _381_InsertDeleteGetRandomDuplicateAllowed o = new _381_InsertDeleteGetRandomDuplicateAllowed();
        o.insert(0);
        o.remove(0);
        o.insert(-1);
        o.remove(0);
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
        o.getRandom();
    }
}
