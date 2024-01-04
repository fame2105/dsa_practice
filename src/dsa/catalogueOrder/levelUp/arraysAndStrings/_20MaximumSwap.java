package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _20MaximumSwap {

    public int maximumSwap(int num) {
        String ans =  maximumSwap(num+"");
        return Integer.parseInt(ans);
    }

    private String maximumSwap(String s) {
        char[] nums = s.toCharArray();

        int[] lastOcuranceOfDigit = new int[10];

        // Fill last occurrence digit array
        for(int i = 0; i < nums.length; i++) {
            int digit = nums[i] - '0';
            lastOcuranceOfDigit[digit] = i;
        }

        // find swapping point
        boolean swapped = false;
        for (int i = 0; i < nums.length; i++) {
            int digit = nums[i] - '0';
            for(int j = 9; j > digit; j--) {
                if(lastOcuranceOfDigit[j] > i) {
                    swap(nums, i, lastOcuranceOfDigit[j]);
                    swapped = true;
                    break;
                }
            }
            if(swapped) break;
        }
        return String.valueOf(nums);
    }

    private static void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
