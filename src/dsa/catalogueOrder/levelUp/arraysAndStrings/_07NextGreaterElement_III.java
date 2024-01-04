package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _07NextGreaterElement_III {
    public static String nextGreaterElement(String str) {
        if (str.length() == 1) return str;

        char[] nums = str.toCharArray();
        int dipIdx = dipIndex(nums);
        if (dipIdx == -1) {
            return "-1";
        }

        int greaterElementThanDipIndex = cielIndex(nums, dipIdx);
        swap(nums, dipIdx, greaterElementThanDipIndex);
        reverse(nums, dipIdx + 1);
        return String.valueOf(nums);
    }

    private static void reverse(char[] nums, int idx) {
        int left = idx;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(char[] nums, int left, int right) {
        char temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static int cielIndex(char[] nums, int dipIdx) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[dipIdx]) return i;
        }
        return -1;
    }

    private static int dipIndex(char[] nums) {
        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }
        return idx;
    }
}
