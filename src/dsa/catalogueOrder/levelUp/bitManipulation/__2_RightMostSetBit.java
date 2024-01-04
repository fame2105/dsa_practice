package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.Scanner;

public class __2_RightMostSetBit {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Method 1
        /*int n2sComplement = (~n + 1);
        int rightMstSetBitMask = (n & n2sComplement);
        System.out.println(Integer.toBinaryString(rightMstSetBitMask));*/

        // Method 2
        int rightMstSetBitMask = n & -n;
        System.out.println(Integer.toBinaryString(rightMstSetBitMask));
    }
}
