package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class __21_FindAnagramMappings {
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
        // Prepare HashMap for arr2
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            int element = arr2[i];
            Queue<Integer> idxs = map.getOrDefault(element, new LinkedList<>());
            idxs.add(i);
            map.put(element, idxs);
        }

        int[] ans = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            int element = arr1[i];
            int position = map.get(element).remove();
            ans[i] = position;
        }
        return ans;
    }
}
