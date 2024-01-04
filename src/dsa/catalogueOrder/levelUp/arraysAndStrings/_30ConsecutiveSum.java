package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _30ConsecutiveSum {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(5)); // 2
    }

    public static int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; 2 * n > k * (k - 1); k++) {
            int numerator = n - (k * (k - 1) / 2);

            if (numerator % k == 0)
                count++;
        }
        return count;
    }
}
