package dsa.catalogueOrder.foundation.numbersystem;

import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        // using the property of numbers -> if (p * q = num) then p and q both cannot be greater than sqrt(num) hence there factors lie in pairs
        for(int div = 2; div * div<= num; div ++) {
            if(num % div == 0) {
                num = num/div;
                System.out.print(div + " ");
            }
        }
        // edge case for numbers such as 46 -> (1 * 23)  p = 1 and q = 23, since loop will exit at 5 since 5*5 is not <= 23 hence the remaining number is itself the other prime factor.
        if(num != 1) {
            System.out.print(num);
        }
    }
}
