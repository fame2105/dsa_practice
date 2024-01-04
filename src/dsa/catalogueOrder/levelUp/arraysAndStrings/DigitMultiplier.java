package dsa.catalogueOrder.levelUp.arraysAndStrings;

// https://practice.geeksforgeeks.org/problems/digit-multiplier3000/1
public class DigitMultiplier {
    /**
     * Given a positive integer N, find the smallest number S such that the product of all the digits of S is equal to the number N.
     * If there's no such number, Print "-1".
     *
     * Example 1:
     * Input:
     * N = 100
     * Output:
     * 455
     * Explanation:
     * 4*5*5 = 100. There are no numbers less than 455 with the product of it's digit as 100.
     *
     * Example 2:
     * Input:
     * N = 26
     * Output:
     * -1
     * Explanation:
     * There are no numbers which can form a product of 26 with its digits.
     */
    static String getSmallest(Long N) {
        if(N == 1) return "1";
        String s = "";
        for(int i = 9; i >= 2; i--) {
            while(N % i == 0) {
                s = i + s;
                N /= i;
            }
        }

        return s.length() == 0 || N != 1 ? "-1" : s;
    }
}
