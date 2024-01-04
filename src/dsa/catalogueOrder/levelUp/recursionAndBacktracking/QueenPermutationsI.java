package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class QueenPermutationsI {

    public static void main(String[] args) {
        int totalQueens = 2;
        int queensPlacedSoFar = 0;
        int[][] chess = new int[totalQueens][totalQueens];

        queensPermutations(queensPlacedSoFar, totalQueens, chess);
    }

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf == tq) {
            for(int i = 0; i < chess.length; i++) {
                for(int j = 0; j < chess[i].length; j++) {
                    if(chess[i][j] == 0) {
                        System.out.print("-" + "\t");
                    } else {
                        System.out.print("q" + chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }


        for(int r = 0; r < chess.length; r++) {
            for(int c = 0; c < chess[r].length; c++) {
                if(chess[r][c] == 0) {
                    chess[r][c] = qpsf+1;
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[r][c] = 0;
                }
            }
        }
    }
}
