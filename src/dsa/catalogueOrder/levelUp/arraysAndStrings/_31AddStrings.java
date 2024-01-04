package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _31AddStrings {
    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "9999";

        System.out.println(addStrings(num1, num2));
    }

    /**
     * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
     * <p>
     * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
     * You must also not convert the inputs to integers directly.
     * <p>
     * Constraints:
     * 1 <= num1.length, num2.length <= 104
     * num1 and num2 consist of only digits.
     * num1 and num2 don't have any leading zeros except for the zero itself.
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder("");
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;

            ans.insert(0, sum);
            i--;
            j--;
        }
        return ans.toString();
    }
}
