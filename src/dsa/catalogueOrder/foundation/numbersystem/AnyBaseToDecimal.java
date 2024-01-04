package dsa.catalogueOrder.foundation.numbersystem;

public class AnyBaseToDecimal {

    /**
     *
     * @param num : number to be converted to Decimal Base
     * @param base : current base of the number
     * @return number converted to decimal base
     */
    private static long anyBaseToDecimal(int num, int base) {
        long convertedValue = 0l;
        int pow = 0;
        while (num != 0) {
            int digit = num % 10;
            num /= 10;
            convertedValue += digit * Math.pow(base, pow);
            pow++;
        }
        return convertedValue;
    }

    public static void main(String[] args) {
        int test1 = 77;
        int test2 = 1172;
        int test3 = 10;
        System.out.println(anyBaseToDecimal(test1, 8));
        System.out.println(anyBaseToDecimal(test2, 8));
        System.out.println(anyBaseToDecimal(test3, 2));

    }
}
