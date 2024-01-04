package dsa.leetcodeANDgfg;

public class _1544_MakeTheStringGreat {
    public static void main(String[] args) {
//        System.out.println(makeGood("abBAcC"));
//        System.out.println(makeGood("leEeetcode"));
//        System.out.println(makeGood("s"));
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println(makeGood("XxDFOBKRrkbofdXxeEijJIcCsBikPgfxXFGpKIbSemGivrqqQQRVIgMEPBWpPwbpSCWqWQqwQwcsQqasLwGWlSAQq"));
    }

    /**
     *Useful Info:
     * ASCII A - Z : 65 - 90
     * ASCII a - z : 97 - 122
     *
     * Note:
     * Math.abs(uppercaseCharacter - lowercaseCharacter) == 32 OR Math.abs(lowercaseCharacter - uppercaseCharacter) == 32
     * ex : 'b' - 'B' = 32  and 'B' - 'b' = -32
     */
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);

        int idx = 1;

        while(idx < sb.length()) {
            while(idx > 0 && idx < sb.length() && Math.abs(sb.charAt(idx) - sb.charAt(idx-1)) == 32) {
                sb.deleteCharAt(idx);
                sb.deleteCharAt(idx-1);
                idx -= 1; //
            }
            idx++;
        }
        return sb.toString();
    }
}
