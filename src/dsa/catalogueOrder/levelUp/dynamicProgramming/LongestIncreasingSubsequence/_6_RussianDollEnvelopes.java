package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner;

// Exactly like MaxNonOverlappingBridges
public class _6_RussianDollEnvelopes {
    private static class Envelope implements Comparable<Envelope> {
        int width;
        int height;

        Envelope(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int compareTo(Envelope o) {
            if(this.width != o.width) {
                return this.width - o.width;
            } else {
                return this.height - o.height;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        Envelope[] envelopes = new Envelope[n];
        for(int i = 0; i < n; i++) {
            String str = s.nextLine();
            String[] parts = str.split(" ");

            Envelope env = new Envelope(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            envelopes[i] = env;
        }

        Arrays.sort(envelopes);

        int[] dp = new int[n];
        int maxNestedEnvelopes = 0;
        for(int i = 0; i < n; i++) {
            Envelope currentEnvelope = envelopes[i];
            int maxNestedEnvelopesPrev = 0;

            for(int j = 0; j < i; j++) {
                Envelope prevEnvelope = envelopes[j];
                if(currentEnvelope.height > prevEnvelope.height && currentEnvelope.width != prevEnvelope.width) {
                    maxNestedEnvelopesPrev = Math.max(maxNestedEnvelopesPrev, dp[j]);
                }
            }

            dp[i] = maxNestedEnvelopesPrev + 1;
            maxNestedEnvelopes = Math.max(maxNestedEnvelopes, dp[i]);
        }

        System.out.println(maxNestedEnvelopes);
    }
}
