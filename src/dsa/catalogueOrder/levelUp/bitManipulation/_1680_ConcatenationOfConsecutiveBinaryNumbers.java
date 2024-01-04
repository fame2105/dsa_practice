package dsa.catalogueOrder.levelUp.bitManipulation;

// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
// Editorial : https://www.youtube.com/watch?v=3lbd5zTtLro&ab_channel=ThinkCode

public class _1680_ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long ans = 0l;

        for(int i = 1; i <= n; i++) {
            int num = i; // copying value of i to num
            int count = 0; // to count the total no of bits in the ith number

            while(num != 0) {
                count++;
                num = num / 2;
            }
            /*
             * Dry run this part and it shall be clear:
             * Ex: i = 1 , we want to concatenate 2 to 1
             * ans = 01  and 2 = 10
             * In order to concatenate ans with current i , shift the bits in ans by no of bits in curr_i to left
             * ans = 01    X = (01 << 2) = 0100    shift by 2 because there are 2 bits in number curr_i(2)
             * X + curr_i = X + 2 = 0100 + 10 == 0110... now ans becomes 0110 = 6
             *
             * Similarily, concatenate 3 to ans
             * ans = 110   3 = 11, therefore shift ans by 2 bits X = ans << 2
             * X = 11000 , now ans = X + curr_i(3) = 11000 + 11 = 11011, hence ans = 11011
             */
            ans = ((ans << count) + i) % mod;
        }

        return (int) ans % mod;
    }
}
