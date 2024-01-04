package dsa.catalogueOrder.foundation.recursion.backtracking;

import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];

        int currentRow = s.nextInt();
        int currentColumn = s.nextInt();

        printKnightTour(arr, currentRow, currentColumn, 1);
    }

    private static int[][] direction = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2},{-2, -1}};

    // asf -> answerSoFar
    private static void printKnightTour(int[][] arr, int currentRow, int currentColumn, int count) {
        if(count == arr.length * arr[0].length) {
            arr[currentRow][currentColumn] = count;
            displayBoard(arr);
            arr[currentRow][currentColumn] = 0;
            return;
        }

        arr[currentRow][currentColumn] = count;

        for(int d = 0; d < direction.length; d++) {
            int rr = currentRow + direction[d][0];
            int cc = currentColumn + direction[d][1];
            if(rr >= 0 && rr< arr.length && cc >= 0 && cc < arr[0].length && arr[rr][cc] == 0) {
                printKnightTour(arr, rr, cc, count + 1);
            }
        }
        arr[currentRow][currentColumn] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
