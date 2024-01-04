package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] matrix = new int[n][n];

        // fill binary matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        findCelebrity(matrix);
    }

    private static void findCelebrity(int[][] matrix) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int val1 = st.pop();
            int val2 = st.pop();

            if (matrix[val1][val2] == 1) {
                // val1 is not a celebrity, since val1 knows val2 hence push val2 in stack for further inspection
                st.push(val2);
            } else {
                // (except itself, celebrity should be known by everyone) and val1 does not know val2, which means val2 cannot be a celebrity
                st.push(val1);
            }
        }

        // check the last remaining element in the stack
        int potentialCelebrityIndex = st.pop();
        for (int i = 0; i < matrix.length; i++) {
            // check that potentialCelebrityIndex does not knows anyone
            if (matrix[potentialCelebrityIndex][i] != 0) {
                System.out.println("none");
                return;
            }
        }

        // check in column that
        for (int i = 0; i < matrix[potentialCelebrityIndex].length; i++) {
            // check that everyone knows potentialCelebrityIndex except the celebrity itself
            if (i != potentialCelebrityIndex && matrix[i][potentialCelebrityIndex] != 1) {
                System.out.println("none");
                return;
            }
        }

        System.out.println(potentialCelebrityIndex);
    }

}
