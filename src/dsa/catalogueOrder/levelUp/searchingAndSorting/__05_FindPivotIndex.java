package dsa.catalogueOrder.levelUp.searchingAndSorting;

// This question is also termed as Equilibrium index
// Pivot index is the one which when ignored, divides the arr in left and right halves with equal sum.
public class __05_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        // calculate total sum and call it rSum
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];
        }

        int lSum = 0;
        // Subtract element one by one from the rSum and check if it is equal to lSum
        for (int i = 0; i < nums.length; i++) {
            rSum -= nums[i];

            if (lSum == rSum) {
                return i;
            }
            lSum += nums[i];
        }

        return -1;
    }
}
