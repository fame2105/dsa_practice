package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class KPartitionSubset {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i  = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, ans);
    }

    public static int counter = 0;
    public static void solution(int i, int n, int k, ArrayList<ArrayList<Integer>> ans) {
        if(i > n) {
            if(k == 0) {
                counter++;
                System.out.print(counter + ". " + ans);
                System.out.println();
            }
            return;
        }

        for(int j = 0; j < ans.size(); j++)	{
            ArrayList<Integer> subset = ans.get(j);
            if(subset.size() > 0) {
                subset.add(i);
                solution(i+1, n, k, ans);
                subset.remove(subset.size()-1);
            } else {
                subset.add(i);
                solution(i+1, n, k-1, ans);
                subset.remove(subset.size()-1);
                break;
            }
        }
    }
}
