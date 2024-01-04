package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class _21PascalTriangle_II {

    // n is row num.
    public List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
        long val = 1L;
        for(int row = 0; row <= n; row++) {
            list.add((int) val);
            val = val * (n - row) / (row + 1);
        }
        return list;
    }
}
