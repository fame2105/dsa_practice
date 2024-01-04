package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.Arrays;

public class __01_MarksOfPCM {
    public static class Marks implements Comparable<Marks> {
        int phy;
        int chem;
        int math;

        Marks(int phy, int chem, int math) {
            this.phy = phy;
            this.chem = chem;
            this.math = math;
        }

        public int compareTo(Marks o) {
            if (this.phy != o.phy) {
                return this.phy - o.phy;
            } else if (this.chem != o.chem) {
                return o.chem - this.chem;
            } else {
                return this.math - o.math;
            }
        }
    }


    /*You have to complete the body of customSort function,
    after sorting final changes should be made in given arrays only. */
    public static void customSort(int[] phy, int[] chem, int[] math) {
        Marks[] marks = new Marks[phy.length];
        for (int i = 0; i < phy.length; i++) {
            marks[i] = new Marks(phy[i], chem[i], math[i]);
        }

        Arrays.sort(marks);

        for (int i = 0; i < marks.length; i++) {
            phy[i] = marks[i].phy;
            chem[i] = marks[i].chem;
            math[i] = marks[i].math;
        }
    }
}
