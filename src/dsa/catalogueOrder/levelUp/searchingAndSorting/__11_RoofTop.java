package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __11_RoofTop {
    public static int findMaxSteps(int[] arr) {
        int maxSteps = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
            } else {
                if (maxSteps < count) {
                    maxSteps = count;
                }
                count = 0;
            }
        }

        // this extra check is needed because if the increasing sequence is found towards the end, then that will not be updated in the loop,
        // since we are skipping the check with last element.
        if (maxSteps < count) {
            maxSteps = count;
        }

        return maxSteps;
    }
}
