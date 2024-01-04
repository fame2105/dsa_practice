package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class QueenCombinationsI {

    public static void queensCombinationsActualConcepts(int qpsf, int tq, int row, int col, String asf) {
        if (col == tq) {
            row += 1;
            col = 0;
            asf += "\n";
        }

        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }

        // yes call
        if (qpsf < tq) {
            queensCombinationsActualConcepts(qpsf + 1, tq, row, col + 1, asf + "q");
        }

        // no call
        queensCombinationsActualConcepts(qpsf, tq, row, col + 1, asf + "-");
    }
}
