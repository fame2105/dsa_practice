package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class __02_FindItineraryFromTickets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }

        // Create Potential Source map
        HashMap<String, Boolean> potentialSource = new HashMap<>();
        for(String src : map.keySet()) {
            String dest = map.get(src);

            potentialSource.put(dest, false);
            if(potentialSource.containsKey(src)) {
                continue;
            } else {
                potentialSource.put(src, true);
            }
        }

        // find originalSource
        String originalSource = "";
        for(String src : potentialSource.keySet()) {
            if(potentialSource.get(src) == true) {
                originalSource = src;
                break;
            }
        }
        // traverse and printItinerary
        while(true) {
            if(map.containsKey(originalSource)) {
                System.out.print(originalSource + " -> ");
                originalSource = map.get(originalSource);
            } else {
                System.out.println(originalSource + ".");
                break;
            }
        }
    }
}
