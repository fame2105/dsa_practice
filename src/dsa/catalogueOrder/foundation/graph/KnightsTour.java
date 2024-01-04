package dsa.catalogueOrder.foundation.graph;

import java.util.Scanner;

public class KnightsTour {

    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        /*int n = s.nextInt();
        int initialRow = s.nextInt();
        int initialCol = s.nextInt();*/
        int n = 5;
        int initialRow = 2;
        int initialCol = 0;
        printKnightsTour(new int[n][n], initialRow, initialCol, 1);

    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if(move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;

        for(int i = 0; i < dir.length; i++) {
            int newX = r + dir[i][0];
            int newY = c + dir[i][1];
            if(newX >= 0 && newX < chess.length && newY >= 0 && newY < chess.length && chess[newX][newY] == 0) {
                printKnightsTour(chess, newX, newY, move + 1);
            }
        }

        chess[r][c] = 0;
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
