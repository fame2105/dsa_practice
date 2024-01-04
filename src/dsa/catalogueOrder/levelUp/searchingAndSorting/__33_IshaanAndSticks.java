package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class __33_IshaanAndSticks {
    public static ArrayList<Integer> solve(int[] nums) {
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        int maxArea = 0;
        int countSquares = 0;
        for (int key : fmap.keySet()) {
            if (fmap.get(key) >= 4) {
                int area = key * key;
                int numberOfSqaures = fmap.get(key) / 4;

                if (maxArea < area) {
                    maxArea = area;
                    countSquares = numberOfSqaures;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxArea);
        ans.add(countSquares);
        return ans;
    }
}
