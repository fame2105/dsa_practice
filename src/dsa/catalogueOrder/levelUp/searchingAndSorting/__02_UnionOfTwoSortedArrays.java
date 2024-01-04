package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.ArrayList;

public class __02_UnionOfTwoSortedArrays {
    public static ArrayList<Integer> union(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < a.length && j < b.length) {
            if(a[i] == b[j]) {
                if(ans.size() > 0 && ans.get(ans.size() - 1) != a[i]){
                    ans.add(a[i]);
                } else if(ans.size() == 0){
                    ans.add(a[i]);
                }
                i++;
                j++;
            } else if(a[i] < b[j]) {
                if(ans.size() > 0 && ans.get(ans.size() - 1) != a[i]){
                    ans.add(a[i]);
                } else if(ans.size() == 0){
                    ans.add(a[i]);
                }
                i++;
            } else {
                if(ans.size() > 0 && ans.get(ans.size() - 1) != b[j]){
                    ans.add(b[j]);
                } else if(ans.size() == 0){
                    ans.add(b[j]);
                }
                j++;
            }
        }

        if(i < a.length) {
            if(ans.size() > 0 && ans.get(ans.size() - 1) != a[i]){
                ans.add(a[i]);
            } else if(ans.size() == 0){
                ans.add(a[i]);
            }
            i++;
        }

        if(j < b.length) {
            if(ans.size() > 0 && ans.get(ans.size() - 1) != b[j]){
                ans.add(b[j]);
            } else if(ans.size() == 0){
                ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }
}
