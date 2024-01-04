package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class __01_EmployeesUnderEveryManager {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(scn.next(), scn.next());
        }

        printEmployeesUnderManager(map);
    }

    private static void printEmployeesUnderManager(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap<>(); // manger : <List of employees under this manger>
        String ceo = "";

        // construct tree from employee-manager map
        for(String emp : map.keySet()) {
            String man = map.get(emp);

            if(emp.equals(man)) {
                ceo = man;
            } else {
                if(tree.containsKey(man)) {
                    HashSet<String> employees = tree.get(man);
                    employees.add(emp);
                } else {
                    HashSet<String> employees = new HashSet<>();
                    employees.add(emp);
                    tree.put(man, employees);
                }
            }
        }

        HashMap<String, Integer> ans = new HashMap<>();
        getSize(tree, ceo, ans);

        for(String emp : ans.keySet()) {
            System.out.println(emp + " " + ans.get(emp));
        }

    }

    private static int getSize(HashMap<String, HashSet<String>> tree, String manager, HashMap<String, Integer> ans) {
        if(!tree.containsKey(manager)) {
            ans.put(manager, 0);
            return 1;
        }

        int sz = 0;
        for(String emp : tree.get(manager)) {
            int childSize = getSize(tree, emp, ans);
            sz += childSize;
        }

        ans.put(manager, sz);
        return sz + 1;
    }
}
