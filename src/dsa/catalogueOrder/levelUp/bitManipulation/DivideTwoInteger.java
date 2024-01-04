package dsa.catalogueOrder.levelUp.bitManipulation;

// #29 https://leetcode.com/problems/divide-two-integers/
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if(dividend == 1 << 31 && divisor == -1) return Integer.MAX_VALUE;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int result = 0;
        while(a - b >= 0) {
            int count = 0;
            while(a - (b << 1 << count) >= 0) {
                count++;
            }

            result = result + (1 << count);
            a = a - (b << count);
        }

        int sign = (dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0 ) ? 1 : -1;
        return sign * result;
    }
}
