package dsa.catalogueOrder.levelUp.graph;

public class SatisfiabilityOfEqualityEquation {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for(String eqn : equations) {
            if(eqn.charAt(1) == '=') {
                int var1 = eqn.charAt(0) - 'a';
                int var2 = eqn.charAt(3) - 'a';
                union(var1, var2, parent, rank);
            }
        }

        for(String eqn : equations) {
            if(eqn.charAt(1) == '!') {
                int var1 = eqn.charAt(0) - 'a';
                int var2 = eqn.charAt(3) - 'a';
                int parent_var1 = find(var1, parent);
                int parent_var2 = find(var2, parent);
                if(parent_var1 == parent_var2) return false;
            }
        }
        return true;
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        int lu = find(u, parent);
        int lv = find(v, parent);
        if(lu != lv) {
            if(rank[lu] >  rank[lv]) {
                parent[lv] = lu;
            } else if(rank[lu] < rank[lv]) {
                parent[lu] = lv;
            } else {
                parent[lv] = lu;
                rank[lu]++;
            }
        }
    }
    
    private static int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }
}
