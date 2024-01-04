package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _02ContainerWithMostWater {

    public int mostWater(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int length = right - left;

            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int effectiveHeight = Math.min(leftHeight, rightHeight);
            maxArea = Math.max(maxArea, effectiveHeight * length);

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
