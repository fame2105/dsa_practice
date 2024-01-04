package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class CombinationsII {
    public static void main(String[] args) {
        int nBoxes = 5;
        int rItems = 3;
        combinations(new int[nBoxes], 1, rItems, -1);
    }

    // lb -> lastBoxFilled
    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("i");
                }
            }
            System.out.println();
            return;
        }

        for (int b = lb + 1; b < boxes.length; b++) {
            if (boxes[b] == 0) {
                boxes[b] = ci;
                combinations(boxes, ci + 1, ti, b);
                boxes[b] = 0;
            }
        }
    }
}
