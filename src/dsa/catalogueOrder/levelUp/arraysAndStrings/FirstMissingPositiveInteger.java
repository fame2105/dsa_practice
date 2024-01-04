package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class FirstMissingPositiveInteger {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4}; //  answer -> 5
        int[] input2 = {5, 3, 1, -1}; // answer -> 2

        System.out.println(findMissingPositiveInteger(input1));
        System.out.println(findMissingPositiveInteger(input2));
    }

    // Approach 1 : Highly Unoptimized -> Complexity = o(n2)
    /*private static int findMissingPositiveInteger(int[] nums) {
        // possible numbers in the array should lie between [1 arr.length]
        for (int j = 1; j <= nums.length; j++) {
            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                if(j == nums[i]) {
                    found = true;
                    break;
                }
            }

            if(found == false) return j;

        }
        return nums.length + 1;
    }*/

    // Approach 2 -> Highly Optimized
    private static int findMissingPositiveInteger(int[] nums) {
        // possible numbers in the array should lie between [1 arr.length]
        for (int j = 1; j <= nums.length; j++) {
            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                if(j == nums[i]) {
                    found = true;
                    break;
                }
            }

            if(found == false) return j;
        }
        return nums.length + 1;
    }
}
