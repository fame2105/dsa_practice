package dsa.catalogueOrder.foundation.recursion.backtracking;

public class PrintWaysToSelectBox {

    public static void main(String[] args) {
        printWaysToSelectBox1D(0, 4, 0, "");
    }
    // cb - currentBox
    // tb -> total boxes to be placed
    // bsf -> box so far
    // asf -> answerSoFar
    public static void printWaysToSelectBox1D(int cb, int tb, int bsf, String asf) {
        if (cb == tb) {
            if (bsf == 3)
                System.out.println(asf);

            return;
        }
        // yes call
        if (bsf + 1 <= 3)
            printWaysToSelectBox1D(cb + 1, tb, bsf + 1, asf + "b" + cb + " ");
        // no call
        printWaysToSelectBox1D(cb + 1, tb, bsf, asf);
    }


    // dimension of box -> n(total row) * m (total col),
    // r-> row, c -> col, bsf -> box so far, asf-> answer so far
    public static void printWaysToSelectBox2D(int n, int m, int r, int c, int bsf, String asf) {
        if(r == n) {
            if(bsf == 2)
                System.out.println(asf);
            return;
        }

        if(c + 1 < m) { // next column is valid
            // yes call
            printWaysToSelectBox2D(n, m, r + 1, 0, bsf + 1, asf + "(" + r + "-" + c +"), ");
            // no call
            printWaysToSelectBox2D(n, m, r, c + 1, bsf, asf);
        } else  { // next column is invalid
            // yes call
            printWaysToSelectBox2D(n, m, r + 1, 0, bsf + 1, asf + "(" + r + "-" + c +"), ");
            // no call
            printWaysToSelectBox2D(n, m, r + 1, 0, bsf, asf);
        }
    }
}
