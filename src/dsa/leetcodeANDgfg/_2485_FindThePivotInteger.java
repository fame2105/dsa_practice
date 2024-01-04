package dsa.leetcodeANDgfg;

// Link : https://leetcode.com/contest/weekly-contest-321/problems/find-the-pivot-integer/ (EASY)
public class _2485_FindThePivotInteger {
    public int pivotInteger(int n) {
        for(int i = 1; i <= n; i++) {
            int sumA = getSum(i);
            int sumB = getSum(n) - sumA + i;

            if(sumA == sumB)
                return i;
        }

        return -1;
    }

    private int getSum(int n) {
        return (n * (n+1)/2);
    }
}
