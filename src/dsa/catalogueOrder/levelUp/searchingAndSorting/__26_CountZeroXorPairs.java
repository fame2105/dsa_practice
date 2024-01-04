package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.HashMap;
import java.util.Map;

public class __26_CountZeroXorPairs {
    public static int countPairs(int[] arr) {
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : arr) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }
        
        int totalPairs = 0;
        for (int key : fmap.keySet()) {
            int freq = fmap.get(key);
            int pairs = ((freq - 1) * freq) / 2;
            totalPairs += pairs;
        }
        return totalPairs;
    }
    
}
