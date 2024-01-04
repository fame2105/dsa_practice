package dsa.catalogueOrder.Test1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }


    /*public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int idx, int target, ArrayList<Integer> currentCombinationSum, ArrayList<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(currentCombinationSum));
            return;
        } else if(target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int candidate = candidates[i];
            currentCombinationSum.add(candidate);
            combinationSumHelper(candidates, i, target-candidate, currentCombinationSum, result);
            currentCombinationSum.remove(currentCombinationSum.size() - 1);
        }
    }*/


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int idx, int target, ArrayList<Integer> currentCombinationSum, ArrayList<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(currentCombinationSum));
            return;
        } else if(target < 0) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int candidate = candidates[i];
            currentCombinationSum.add(candidate);
            combinationSumHelper(candidates, i, target-candidate, currentCombinationSum, result);
            currentCombinationSum.remove(currentCombinationSum.size() - 1);
        }
    }
}
