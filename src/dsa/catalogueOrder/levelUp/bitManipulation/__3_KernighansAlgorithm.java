package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.Scanner;

public class __3_KernighansAlgorithm {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    }

    // https://leetcode.com/problems/number-of-1-bits/description/
    // Method 1 : Iterate on all the bits and check if each bit is set or not
    private static int getCountOfSetBits_1(int num) {
        int mask = 1;
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            if((mask & num) != 0)
                counter += 1;

            mask = (mask << 1);
        }
        return counter;
    }


    /**
     * Method 2: Iterates only on those bits that are set and then perform a difference between number and the rightMostSetBitMask of that number.
     * This algorithm is known as Kernighan's algorithm.
     *
     **/
    private static int getCountOfSetBits_2(int num) {
        int count = 0;
        while(num > 0)  {
            count++;
            int rightMostSetBitMask = num & -num;
            num = num - rightMostSetBitMask; // this operation will make the rightmost set bit in the given num as 0, and then we can calculate the nextRightMostSetBit and keep performing this operation till num > 0.
        }
        return count;
    }
}
