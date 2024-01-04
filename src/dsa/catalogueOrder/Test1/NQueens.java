package dsa.catalogueOrder.Test1;

import dsa.utility.Util;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        System.out.println(Util.reverseList(a, 0, 2));
    }

}

