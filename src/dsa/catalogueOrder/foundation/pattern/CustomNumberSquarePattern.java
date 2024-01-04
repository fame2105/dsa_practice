package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class CustomNumberSquarePattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int changeFactor = 2 * n;
        int iValue = 1;
        for (int i = 1; i <=n ; i++) {
            int currentCounter = iValue;
            for (int j = 1; j <=n ; j++) {
                System.out.print(currentCounter++ + " ");

            }
            System.out.println();

            if(n%2 != 0) {
                if(i <= n/2) {
                    iValue += changeFactor;
                } else if(i == n/2 + 1){
                    iValue -= changeFactor - n;
                } else {
                    iValue -= changeFactor;
                }
            } else {
                if(i < n/2) {
                    iValue += changeFactor;
                } else if(i == n/2) {
                    iValue += changeFactor - n;
                } else {
                    iValue -= changeFactor;
                }
            }
        }
    }
}
