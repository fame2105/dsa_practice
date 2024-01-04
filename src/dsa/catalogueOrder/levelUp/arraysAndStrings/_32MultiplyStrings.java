package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _32MultiplyStrings {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length() + num2.length()];

        int j = num2.length() - 1; // iterates on num2
        int k = res.length - 1; // iterates on res[] array

        while(j >= 0) {
            int i = num1.length() - 1; // iterates on num1
            int mul = num2.charAt(j) - '0';
            int resIdx = k;
            int carry = 0;

            while(i >=0 || carry != 0) {
                int num = i >= 0 ? num1.charAt(i) - '0' : 0;
                int prod = mul * num;

                prod = prod + carry + res[resIdx];
                res[resIdx] = prod % 10;
                carry = prod / 10;

                resIdx--;
                i--;
            }

            k--;
            j--;
        }

        boolean leadingZeroFlag = false;
        StringBuilder ans = new StringBuilder("");
        for(int l = 0; l < res.length; l++) {
            if(res[l] == 0 && leadingZeroFlag == false) continue;

            leadingZeroFlag = true;
            ans.append(res[l]);
        }

        return ans.toString();
    }
}
