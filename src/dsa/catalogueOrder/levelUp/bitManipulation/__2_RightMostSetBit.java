package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.Scanner;

public class __2_RightMostSetBit {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number = 76 then answer should be int(4) or binary(100)
        System.out.println(getRightMostSetBitMask_1(n) + " and Binary is "+ Integer.toBinaryString(getRightMostSetBitMask_1(n)));
        System.out.println(getRightMostSetBitMask_2(n) + " and Binary is "+ Integer.toBinaryString(getRightMostSetBitMask_2(n)));
        System.out.println(getRightMostSetBitMask_3(n) + " and Binary is "+ Integer.toBinaryString(getRightMostSetBitMask_3(n)));
    }

    // Method 1
    /*Explanation for why the below trick works
     * num = [x 0s  1s] 1 [y 0s]
     * num1sComplement = ~ num = [x 1s 0s] 0 [y 1s]
     * num2sComplement = num1sComplement + 1 = [x 1s 0s] 1 [y 0s]
     * rightMstSetBitMask = num & num2sComplement
     *
     * PS: Any num's 2's complement = -num
     */
    private static int getRightMostSetBitMask_1(int num) {
        int rightMostSetBit = num & (-num);
        return rightMostSetBit;
    }

    // Method 2 = Same as Method 1 but step by step
    private static int getRightMostSetBitMask_2(int num) {
        int n2sComplement = (~num + 1);
        int rightMstSetBitMask = (num & n2sComplement);
        return rightMstSetBitMask;
    }

    // Method 3 = Using a loop to find the rightmost set bit
    private static int getRightMostSetBitMask_3(int num) {
        if(num == 0) return 0;
        int mask = 1;
        for(int i = 0; i <32; i++) {
            if((num & mask) != 0)
                return mask;
            mask = mask << 1;
        }
        return mask;
    }
}
