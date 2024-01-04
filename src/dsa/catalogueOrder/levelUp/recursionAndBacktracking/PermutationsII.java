package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class PermutationsII {
    public static void main(String[] args) {
        int boxes = 3;
        int items = 2;
        permutationII(0, boxes, new int[items], 0, items, "");
    }

    private static void permutationII(int cb, int tb, int[] items, int isf, int ti, String asf) {
        if(cb == tb) {
            if(isf == ti) {
                System.out.println(asf);
            }
            return;
        }

        // yes call
        for(int i = 0; i < items.length; i++) {
            if(items[i] == 0) {
                // select Item
                items[i] = 1;
                permutationII(cb+1, tb, items, isf+1, ti, asf + (i + 1));
                items[i] = 0;
            }
        }

        // no call
        permutationII(cb+1, tb, items, isf, ti, asf + 0);
    }
}
