package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class __01_PermutationsI {
    public static void main(String[] args) {

    }

    // ci -> currentItem  ti -> totalItems
    public static void permutations(int[] boxes, int ci, int ti){
        if(ci > ti) {
            for(int i = 0; i < boxes.length; i++) {
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }
        for(int box = 0; box < boxes.length; box++) {
            if(boxes[box] == 0) {
                boxes[box] = ci;
                permutations(boxes, ci+1, ti);
                boxes[box] = 0;
            }
        }
    }
}
