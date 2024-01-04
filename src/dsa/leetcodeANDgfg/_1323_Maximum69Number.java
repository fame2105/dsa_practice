package dsa.leetcodeANDgfg;

public class _1323_Maximum69Number {
    public int maximum69Number (int num) {

        int numCopy = num;
        int idxSix = -1; // idx of the most left number which is = 6
        int currIdx = 0; // starting from right, currentIdx of a num is 0 Ex. 969
                                                                            //210
        while(num != 0) {
            int digit = num % 10;
            if(digit == 6) {
                idxSix = currIdx;
            }

            currIdx += 1;
            num /= 10;
        }

        return idxSix == -1 ? numCopy : numCopy + 3 * (int)Math.pow(10, idxSix);
    }
}
