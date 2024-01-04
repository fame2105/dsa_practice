package dsa.catalogueOrder.levelUp.arraysAndStrings;

//
public class PartitionIntoDisjointSets {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];

        rightMin[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);

        int maxLeft = nums[0];
        int count = 1;
        for(int i = 0; i < n-1; i++) {
            maxLeft = Math.max(maxLeft, nums[i]);
            if(maxLeft <= rightMin[i+1])
                break;

            count++;
        }
        return count;
    }
}
