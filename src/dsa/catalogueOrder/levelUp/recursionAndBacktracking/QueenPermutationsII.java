package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class QueenPermutationsII {
    public static void main(String[] args) {
        int n = 2;
        boolean[] queens = new boolean[n];
        queensPermutations(0, n, 0, 0, "", queens);
    }

    // queens arrays is to detect which items have been places at what level,
    // so we do not try to place the same item again at the next level of a next box
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq) {
            if(qpsf == tq) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }

        for(int q = 0; q < queens.length; q++) {
            if(queens[q] == false) {
                queens[q] = true;

                if(col + 1 < tq) {
                    queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (q+1) + "\t", queens);
                } else {
                    queensPermutations(qpsf + 1, tq, row + 1, 0, asf + "q" + (q+1) + "\n", queens);
                }

                queens[q] = false;
            }
        }

        // no call
        if(col + 1 < tq) {
            queensPermutations(qpsf, tq, row, col + 1, asf +  "-\t", queens);
        } else {
            queensPermutations(qpsf, tq, row + 1, 0, asf + "-\n", queens);
        }
    }
}
