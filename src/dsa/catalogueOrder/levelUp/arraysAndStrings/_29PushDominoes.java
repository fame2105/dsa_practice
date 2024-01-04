package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _29PushDominoes {
    public static void main(String[] args) {
        String input1 = "RR.L";
        String input2 = ".L.R...LR..L..";

        System.out.println(pushDominoes(input1));
        System.out.println(pushDominoes(input2));
    }
    public static String pushDominoes(String str) {
        char[] dominos = new char[str.length() + 2];
        dominos[0] = 'L';
        dominos[dominos.length - 1] = 'R';

        for (int i = 1; i < dominos.length - 1; i++) {
            dominos[i] = str.charAt(i - 1);
        }

        int i = 0;
        int j = 1;
        while (j < dominos.length) {
            if (dominos[j] == '.') {
                j++;
                continue;
            }
            solveConfig(dominos, i, j);
            i = j;
            j++;
        }

        String ans = "";
        for(int k = 1; k < dominos.length - 1; k++) {
            ans += dominos[k];
        }

        return ans;
    }

    private static void solveConfig(char[] dominos, int i, int j) {
        if (dominos[i] == 'L' && dominos[j] == 'L') {
            // dominos in between i and j become L
            for (int k = i + 1; k < j; k++)
                dominos[k] = 'L';

        } else if (dominos[i] == 'L' && dominos[j] == 'R') {
            // do nothing

        } else if (dominos[i] == 'R' && dominos[j] == 'R') {
            // dominos in between i and j become R
            for (int k = i + 1; k < j; k++)
                dominos[k] = 'R';

        } else if (dominos[i] == 'R' && dominos[j] == 'L') {
            while (i < j) {
                dominos[i++] = 'R';
                dominos[j--] = 'L';
            }
        }
    }
}
