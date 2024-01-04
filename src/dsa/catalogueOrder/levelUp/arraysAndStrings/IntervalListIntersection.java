package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args) {

    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[0][0];

        List<int[]> ans = new ArrayList<>();

        int i = 0; // pointer for firstList
        int j = 0; // pointer for secondList

        while (i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];
            int csp = Math.max(first[0], second[0]);
            int cep = Math.min(first[1], second[1]);

            if (csp <= cep) {
                ans.add(new int[]{csp, cep});
            }

            if (first[1] <= second[1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
