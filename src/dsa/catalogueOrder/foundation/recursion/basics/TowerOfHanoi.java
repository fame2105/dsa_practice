package dsa.catalogueOrder.foundation.recursion.basics;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // no of discs
        String tower1 = s.next();
        String tower2 = s.next();
        String tower3 = s.next();

        /**
         * no of discs to be moved from source tower to destination tower using helper tower -> parameter position = 1
         * tower1 is a positional parameter which indicates that currently n discs are placed on tower1 -> parameter position = 2 (source tower)
         * tower2 is a positional parameter which indicates that we want to move n discs from tower1 to tower2 -> parameter position = 3 (destination tower)
         * tower3 is a positional parameter that is used to perform the MOVE from source tower to destination tower using this as a helper tower -> parameter position = 4 (helper tower)
         */
        towerOfHanoi(n, tower1, tower2, tower3);
    }

    private static void towerOfHanoi(int n, String tower1, String tower2, String tower3) {

        // Do not have any discs to move -> base case
        if(n == 0) {
            return;
        }

        // Move upper n-1 discs from tower 1 to tower3 using tower2 as helper
        // after this call n-1 discs will be at tower3 and tower1(source) and tower2(helper) will be empty.
        towerOfHanoi(n-1, tower1, tower3, tower2);

        // Move nth(last most bigger/heavy disc) disc from tower1(source) to tower2(destination)
        System.out.println("Move " + n +" from tower ["+ tower1 +" -> "+ tower2 + "]");

        // Move n-1 discs from tower3 to tower2 using tower1 as helper
        // after this call n-1 discs will be at tower2 and tower1(helper) and tower3(source) will be empty.
        towerOfHanoi(n-1, tower3, tower2, tower1);
    }
}
