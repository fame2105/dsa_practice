package dsa.leetcodeANDgfg;

public class _441_ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5)); // 2
        System.out.println(arrangeCoins(8)); // 3
        System.out.println(arrangeCoins(2)); // 1
        System.out.println(arrangeCoins(1)); // 1
        System.out.println(arrangeCoins(64)); // 10
    }
     /*public int arrangeCoins(int n) {
         if(n == 1) return 1;

         int rows = 0, i = 1;
         while(n - i >= 0) {
             n = n - i;
             i += 1;
             rows += 1;
         }
         return rows;
     }*/

    public static int arrangeCoins(int n) {
        if(n == 1) return 1;

        long low = 1, high = n;
        while(low <= high) {
            long mid = low + (high - low)/2;
            long sum = mid * (mid + 1) / 2;
            if(sum == n) {
                return (int) mid;
            } else if(sum < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }
}
