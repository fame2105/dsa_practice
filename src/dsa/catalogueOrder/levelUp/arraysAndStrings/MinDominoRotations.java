package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class MinDominoRotations {

    /**
     * The whole Problem revolves around this idea:
     * Let's  say : A = tops[0]  and B = bottoms[0]
     * <p>
     * Either all the dominos in tops[] could be made to A/B OR
     * all the dominos in bottoms[] could be made to A/B
     * <p>
     * count1 -> Rotations to make tops[] to -> A
     * count2 -> Rotations to make tops[] to -> B
     * <p>
     * count3 -> Rotations to make bottoms[] to -> A
     * count4 -> Rotations to make bottoms[] to -> B
     * <p>
     * Answer will be min(count1, count2, count3, count4)
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int marker = tops.length + 1; // can be any max value
        int A = tops[0];
        int B = bottoms[0];

        int count1 = 0; // Rotations to make all the dominos on tops as A
        int count2 = 0; // Rotations to make all the dominos on tops as B
        int count3 = 0; // Rotations to make all the dominos on bottoms as A
        int count4 = 0; // Rotations to make all the dominos on bottoms as B

        int idx = 0;
        while (idx < tops.length) { // could also write bottoms.length
            if (count1 != marker) {
                if (tops[idx] == A) {
                    // do nothing
                } else if (bottoms[idx] == A) {
                    count1++;
                } else {
                    count1 = marker;
                }
            }

            if (count2 != marker) {
                if (tops[idx] == B) {
                    // do nothing
                } else if (bottoms[idx] == B) {
                    count2++;
                } else {
                    count2 = marker;
                }
            }

            if (count3 != marker) {
                if (bottoms[idx] == A) {
                    // do nothing
                } else if (tops[idx] == A) {
                    count3++;
                } else {
                    count3 = marker;
                }
            }

            if (count4 != marker) {
                if (bottoms[idx] == B) {
                    // do nothing
                } else if (tops[idx] == B) {
                    count4++;
                } else {
                    count4 = marker;
                }
            }

            idx++;
        }

        int res = Math.min(count1, Math.min(count2, Math.min(count3, count4)));

        return res == marker ? -1 : res;
    }

}
