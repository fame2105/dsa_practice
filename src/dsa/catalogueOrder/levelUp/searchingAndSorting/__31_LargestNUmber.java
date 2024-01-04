package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.Arrays;

public class __31_LargestNUmber {
    public static String largestNumber(int[] nums) {
        // Convert Integer arr to String arry
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = nums[i] + "";
        }

        // Sort the String arr in custom lexiographical order
        /*
         * Default Lexiographical sort will consider 32 > 3 but number formed by it will
         * be smaller 323 is smaller than 332... hence the need for custom sort
         */

        Arrays.sort(strNums, (a, b) -> {
            long n1 = Long.parseLong(a + b);
            long n2 = Long.parseLong(b + a);

            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            } else {
                return 0;
            }
        });

        // Traverse the sorted String array from reverse and create a String by
        // appending the numbers
        StringBuilder sb = new StringBuilder("");
        for (int i = strNums.length - 1; i >= 0; i--) {
            sb.append(strNums[i]);
        }

        if (sb.charAt(0) == '0') { // Consider input as [0, 0, 0] , sb would contain "000" therefore check before
                                   // returning
            return "0";
        }
        return sb.toString();
    }
}
