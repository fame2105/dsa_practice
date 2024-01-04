package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.Scanner;

public class __1_BasicPfBitManipulation {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        int onMask = (1 << i);
        int offMask = ~(1 << j);
        int toggleMask = (1 << k);
        int checkMask = (1 << m);

        System.out.println(n | onMask);
        System.out.println(n & offMask);
        System.out.println(n ^ toggleMask);

        boolean check = (n & checkMask) == 0 ? false : true;
        System.out.println(check);
    }
}
