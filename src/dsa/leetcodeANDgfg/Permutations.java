package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] input = new int[]{1,2, 3};
        List<List<Integer>> result = permutations(input, 0);
        System.out.println(result);
    }

    // Approach 1 -> solving in post order
    private static List<List<Integer>> permutations(int[] input, int index) {
        if (index == input.length){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<Integer>());
            return list;
        }

        List<List<Integer>> result = permutations(input, index + 1);
        int val = input[index];

        for (int i = result.size() - 1; i >= 0; i--) {
            if (!result.isEmpty()) {
                List<Integer> child = result.remove(i);
                for (int j = 0; j <= child.size(); j++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(child);
                    temp.add(j, val);
                    result.add(temp);
                }
            }
        }
        return result;
    }


    // Approach 1 -> solving in pre order
   /* private static List<List<Integer>> permutations(int[] input, int index, List<List<Integer>> result) {
        if (index == input.length){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<Integer>());
            return list;
        }

        List<List<Integer>> result = permutations(input, index + 1);
        int val = input[index];

        for (int i = result.size() - 1; i >= 0; i--) {
            if (!result.isEmpty()) {
                List<Integer> child = result.remove(i);
                for (int j = 0; j <= child.size(); j++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(child);
                    temp.add(j, val);
                    result.add(temp);
                }
            }
        }
        return result;
    }*/
}
