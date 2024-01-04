package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.Scanner;

public class __3_KernighansAlgorithm {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int count = 0;
        while(n > 0)  {
            count++;
            int rsbm = n & -n;
            n = n - rsbm;
        }

        System.out.println(count);
    }
}
