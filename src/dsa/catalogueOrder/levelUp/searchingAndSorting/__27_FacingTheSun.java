package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __27_FacingTheSun {
    public static int countBuildings(int[] ht) {
        int max = ht[0];
        int count = 1;

        for (int i = 1; i < ht.length; i++) {
            if (ht[i] > max) {
                count++;
                max = ht[i];
            }
        }
        return count;
    }
}
