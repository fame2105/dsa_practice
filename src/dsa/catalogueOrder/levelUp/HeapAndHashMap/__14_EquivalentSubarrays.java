package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.HashSet;

public class __14_EquivalentSubarrays {

    public static int equivalentSubarrays(int[] arr) {
        HashSet<Integer> set = new HashSet<>(); // create set with unique Integers.
        for (int i : arr) {
            set.add(i);
        }

        int j = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && map.size() < set.size()) {
                int element = arr[j];
                map.put(element, map.getOrDefault(element, 0) + 1);
                j++;

                if (map.size() == set.size()) {
                    int eqSubArrays = arr.length - j + 1;
                    count += eqSubArrays;
                }
            }

            if (i < j && map.size() == set.size()) {
                int element = arr[i];
                if (map.get(element) == 1) {
                    map.remove(element);
                } else {
                    map.put(element, map.get(element) - 1);
                }

                if (map.size() == set.size()) {
                    int eqSubArrays = arr.length - j + 1;
                    count += eqSubArrays;
                }
            }
        }
        return count;
    }
}
