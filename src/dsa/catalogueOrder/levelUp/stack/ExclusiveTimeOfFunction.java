package dsa.catalogueOrder.levelUp.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction {
    private class Pair {
        int id; // functionId
        int st; // start time
        int ct; // time taken by a child process to complete

        public Pair(int id, int st, int ct) {
            this.id = id;
            this.st = st;
            this.ct = ct;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Pair> st = new Stack<>();
        for(String entry : logs) {
            String log[] = entry.split(":"); // id:start/end:time
            if(log[1].equals("start")) {
                int functionId = Integer.parseInt(log[0]);
                int startTime = Integer.parseInt(log[2]);
                st.push(new Pair(functionId, startTime, 0));
            } else { // end time of a function is given
                Pair pop = st.pop();
                int interval = Integer.parseInt(log[2]) - pop.st + 1;
                int childProcessTime = pop.ct;
                int totalExclusiveTime = interval - childProcessTime;
                ans[pop.id] += totalExclusiveTime;

                st.peek().ct += interval;
            }
        }
        return ans;
    }

}
