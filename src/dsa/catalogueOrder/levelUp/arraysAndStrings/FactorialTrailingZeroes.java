package dsa.catalogueOrder.levelUp.arraysAndStrings;

// https://leetcode.com/problems/factorial-trailing-zeroes/

/** Explanation of the solution
 * The idea is:
 *
 * The ZERO comes from 10.
 * The 10 comes from 2 x 5
 * And we need to account for all the products of 5 and 2. likes 4×5 = 20 ...
 * So, if we take all the numbers with 5 as a factor, we'll have way more than enough even numbers to pair with them to get factors of 10
 * Example One
 *
 * How many multiples of 5 are between 1 and 23? There is 5, 10, 15, and 20, for four multiples of 5. Paired with 2's from the even factors, this makes for four factors of 10, so: 23! has 4 zeros.
 *
 * Example Two
 *
 * How many multiples of 5 are there in the numbers from 1 to 100?
 *
 * because 100 ÷ 5 = 20, so, there are twenty multiples of 5 between 1 and 100.
 *
 * but wait, actually 25 is 5×5, so each multiple of 25 has an extra factor of 5, e.g. 25 × 4 = 100，which introduces extra of zero.
 *
 * So, we need know how many multiples of 25 are between 1 and 100? Since 100 ÷ 25 = 4, there are four multiples of 25 between 1 and 100.
 *
 * Finally, we get 20 + 4 = 24 trailing zeroes in 100!
 *
 * The above example tell us, we need care about 5, 5×5, 5×5×5, 5×5×5×5 ....
 *
 * Example Three
 *
 * By given number 4617.
 *
 * 5^1 : 4617 ÷ 5 = 923.4, so we get 923 factors of 5
 *
 * 5^2 : 4617 ÷ 25 = 184.68, so we get 184 additional factors of 5
 *
 * 5^3 : 4617 ÷ 125 = 36.936, so we get 36 additional factors of 5
 *
 * 5^4 : 4617 ÷ 625 = 7.3872, so we get 7 additional factors of 5
 *
 * 5^5 : 4617 ÷ 3125 = 1.47744, so we get 1 more factor of 5
 *
 * 5^6 : 4617 ÷ 15625 = 0.295488, which is less than 1, so stop here.
 *
 * Then 4617! has 923 + 184 + 36 + 7 + 1 = 1151 trailing zeroes.
 */

/** Explanation of the Solution
 * If we knew how many times we could divide n! by 10 without causing it to no longer be an integer, we would have our answer. For example, if n! equaled 3628800, we could divide it by 10 twice and the result would still be an integer. This is because there are two trailing zeroes. The number of times we can divide an integer by 10 before it is no longer an integer can be referred to as the number of factors of 10 in the integer.
 *
 * 10's prime factors are 5 and 2. No two other prime numbers multiply to equal 10 (if you don't believe this, try now to find two other prime numbers that multiply to equal 10). The above means that for every factor of 10 that can be found in a number, there is exactly one factor of 5 and one factor of 2. In other words, one factor of 5 and one factor of 2 in an integer mean the integer has one factor of 10. And the number of factors of 10 in n! is the answer we're looking for.
 *
 * So, if we can figure out the lesser of how many 5s and how many 2s are hiding within the sequence of numbers being multiplied together in the calculation for n!, we will know how many 10s are hiding there - and we will have our answer (see above if you don't understand why).
 *
 * Every other number (i.e. every even number) in the calculation for n! will have at least one factor of 2, so the number of factors of 2 will far exceed the number of factors of 5. Because we're looking for the lesser of the two, we can just focus on finding the number of factors of 5.
 *
 * All multiples of 5 have at least one factor of 5. Powers of 5, as in 5^2 or 5^3, have more than one factor of 5, so those needs to be counted more than once. More on that later.
 *
 * The equation for calculating the number of multiples of 5 within n! is n / 5. For example, 10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10. Did you spot the multiples of 5? They are 5 and 10, so there are two multiples of 5 in 10!. There are 10 total numbers being multiplied together in 10! and we encounter a multiple of 5 every 5 numbers. So, in 10 numbers, we encounter 2 multiples of 5.
 *
 * So, for every multiple of 5 in n!, we know we have a factor of 5 (which means we have a factor of 10 and the number of factors of 10 is the number of zeroes at the end of n!). So, using a variable to store the count of factors of 5, we can use the equation above and add n / 5 to our count.
 *
 * But we're not done yet. We need to be sure to count the additional 5s hiding in numbers like 25, 625, 5^4, 5^5, etc. These numbers are multiples of 5, so they've already been counted once, but they contain additional factors of 5 that need to be counted again. 25 has one more factor of 5. 625 has two more. 5^4 has three more, etc.
 *
 * To handle the additional factors of 5 the multiples of 25 contribute, we can just add the number of multiples of 25 to our count. They were already counted once when we added the number of multiples of 5 to our count. That took care of their first factor of 5. Counting them once again takes cares of their second factor of 5. To do this, we can use the equation for calculating the number of multiples of a number in n! again, adding n / 25 to our count.
 *
 * The same needs to be done for multiples of 625. They have a total of three factors of 5. The first was counted when we counted the number of multiples of 5. The second was counted when we counted the number of multiples of 25 (multiples of 625 are also multiples of 25). We can count the third by counting the number of multiples of 625. So, count += n / 625.
 *
 * We can stop counting when we reach the point where we're not getting back any multiples. For example, 10! doesn't have any multiples of 25, much less 625. So, we can stop counting once our calculation for the number of multiples returns 0 (i.e. the denominator is so large that the calculation results in a number less than 1).
 *
 * The way to grow the denominator from 5 to 25 to 625 and on is to just keep dividing by 5. After all, n / 25 = (n / 5) / 5. And the local count of the multiples for the current power of 5 can be elegantly reused in our algorithm as the value which we divide by 5 again to calculate the number of multiples of the next power of 5.
 */
public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }

    // both the trailing zeros do the same thing. count the factors of 5 then 25 then 125 then 625 and so on..
    public static int trailingZeroes_(int n) {
        int count = 0;
        int factor = 5;
        while(n/factor > 0) {
            int temp = n/factor;
            count += temp;
            factor *= 5;
        }
        return count;
    }
}
