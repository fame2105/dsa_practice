package dsa.catalogueOrder.foundation.numbersystem;

class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int pow = 0;
        int res = 0;
        int len = columnTitle.length();
        for(int i = len-1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            int val = (int)c - 65 + 1;
            res = res + val * (int) Math.pow(26, pow);
            pow++;
        }
        
        return res;
    }

    public static void main(String[] args) {
        System.out.println((char)90);
    }

}