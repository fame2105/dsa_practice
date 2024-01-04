package dsa.catalogueOrder.foundation.recursion.backtracking;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int columns = s.nextInt();

        /**
         Testcase 1 :

         3 3
         0 0 0
         1 0 1
         0 0 0

         */

        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        // visited matrix prevents us from moving a path having redundant blocks.
        boolean[][] visited = new boolean[rows][columns];
        floodFill(arr, 0, 0, "", visited);
    }

    private static void floodFill(int[][] maze, int row, int column, String pathSoFar, boolean[][] visited) {
        if (row < 0 || column < 0 || row >= maze.length || column >= maze[0].length || maze[row][column] == 1 || visited[row][column] == true) {
            return;
        } else if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.print(pathSoFar + "\t");
            return;
        }

        visited[row][column] = true;
        floodFill(maze, row - 1, column, pathSoFar + "T", visited); // top
        floodFill(maze, row, column - 1, pathSoFar + "L", visited); // left
        floodFill(maze, row + 1, column, pathSoFar + "D", visited); // down
        floodFill(maze, row, column + 1, pathSoFar + "R", visited); // right
        visited[row][column] = false;
    }

    static int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static char[] dir = {'t', 'l', 'd', 'r'};

    private static void floodFill2(int[][] maze, int sr, int sc, String psf) {
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        maze[sr][sc] = 1;
        for (int d = 0; d < dir.length; d++) {
            int rr = sr + moves[d][0];
            int cc = sc + moves[d][1];
            char direction = dir[d];
            if (rr >= 0 && rr < maze.length && cc >= 0 && cc < maze[0].length && maze[rr][cc] != 1) {
                floodFill2(maze, rr, cc, psf + direction);
            }
        }
        maze[sr][sc] = 0;
    }
}
