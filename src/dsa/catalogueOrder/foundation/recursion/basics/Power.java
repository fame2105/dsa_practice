package dsa.catalogueOrder.foundation.recursion.basics;

import java.util.Scanner;

public class Power {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();

        System.out.println(powerLinear(x, n));
        System.out.println(powerLogarithmic(x, n));
    }

    // complexity -> linear -> O(n)
    private static int powerLinear(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * powerLinear(x, n - 1);
    }

    // complexity is logarithmic -> takes log(n) steps to calculate. for ex (2^32) is calculated is log(2^32) -> 5 steps
    private static int powerLogarithmic(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xnb2 = powerLogarithmic(x, n / 2);
        int xn = xnb2 * xnb2;

        // in case n is odd then multiply xn with x one more time.
        if (n % 2 == 1) {
            xn *= x;
        }
        return xn;
    }

}
