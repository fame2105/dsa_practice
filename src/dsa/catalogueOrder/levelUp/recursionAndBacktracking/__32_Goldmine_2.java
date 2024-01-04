package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class __32_Goldmine_2 {

    static int max = 0;
    public static void getMaxGold(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    int res = dfs(arr, i, j);
                    max = Math.max(res, max);
                }
            }
        }
    }

    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};

    private static int dfs(int[][] mine, int row, int col) {
        int val = mine[row][col];
        mine[row][col] = 0;

        for (int d = 0; d < xdir.length; d++) {
            int r = row + xdir[d];
            int c = col + ydir[d];

            if (r < mine.length && r >= 0 && c < mine[r].length && c >= 0 && mine[r][c] != 0) {
                val += dfs(mine, r, c);
            }
        }

        return val;
    }
}
