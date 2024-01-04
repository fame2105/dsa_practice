package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class CombinationI {
    public static void main(String[] args) {

    }

    // cb -> currentBox
    // total boxes
    //isf -> itemSelectedSoFar
    // ti -> totalItems
    // asf -> answerSoFar
    private static void combinationsI(int cb, int tb, int isf, int ti, String asf) {
        if (cb > tb) {
            if (isf == ti) {
                System.out.println(asf);
            }
            return;
        }

        if (isf < ti) {
            combinationsI(cb + 1, tb, isf + 1, ti, asf + "i");
        }
        combinationsI(cb + 1, tb, isf, ti, asf + "-");
    }

}
