package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __30_PunishTheStudents {
    public static boolean shouldPunish(int[] roll, int[] marks, double avg) {
        int swaps = 0;
        for (int i = 0; i < roll.length - 1; i++) {
            for (int j = 0; j < roll.length - 1 - i; j++) {
                if (roll[j] > roll[j + 1]) {
                    int temp = roll[j];
                    roll[j] = roll[j + 1];
                    roll[j + 1] = temp;

                    swaps++;
                }
            }
        }
        
        double newAvg = 0.0;
        for (int num : marks) {
            newAvg += num;
        }

        newAvg = (newAvg - swaps) / roll.length;
        return newAvg >= avg;
    }
}
