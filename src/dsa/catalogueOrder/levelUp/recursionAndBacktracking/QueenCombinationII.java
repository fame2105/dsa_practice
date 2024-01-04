package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class QueenCombinationII {
    public static void main(String[] args) {

    }

    public static void queenCombinationII(int qpsf, int tq, boolean[][] chess, int lRow, int lCol) {
        if(qpsf == tq) {
            for(int i = 0; i < chess.length; i++) {
                for(int j = 0; j < chess[i].length; j++) {
                    if(chess[i][j] == false) {
                        System.out.print("-" + "\t");
                    } else {
                        System.out.print("q" + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // for places in current row
        for(int c = lCol + 1; c < chess[lRow].length; c++) {
            if(chess[lRow][c] == false) {
                chess[lRow][c] = true;
                queenCombinationII(qpsf + 1, tq, chess, lRow, c);
                chess[lRow][c] = false;
            }
        }

        for(int r = lRow + 1; r < chess.length; r++) {
            for(int c = 0; c < chess[r].length; c++) {
                if(chess[r][c] == false) {
                    chess[r][c] = true;
                    queenCombinationII(qpsf + 1, tq, chess, r, c);
                    chess[r][c] = false;
                }
            }
        }
    }
}
