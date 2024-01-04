package dsa.catalogueOrder.foundation.numbersystem;

public class AnyBaseToAnyBase {

    /**
     *
     * @param num1 :
     * @param base1 :
     * @param base2:
     * @return
     */
    private static long anyBaseToAnyBase(int num1, int base1, int base2) {
        long num1Decimal = anyBaseToDecimal(num1, base1);
        long num1DestinationBase = decimalToAnyBase(num1Decimal, base2);
        return num1DestinationBase;
    }

    /**
     *
     * @param num : number to be converted to Decimal Base
     * @param base : current base of the number
     * @return number converted to decimal base
     */
    private static long anyBaseToDecimal(long num, int base) {
        long convertedValue = 0l;
        int pow = 0;
        while (num != 0) {
            int digit =(int) num % 10;
            num /= 10;
            convertedValue += digit * Math.pow(base, pow);
            pow++;
        }
        return convertedValue;
    }

    private static long decimalToAnyBase(long num, int base) {
        long convertedValue = 0l;
        int pow = 0;
        while (num != 0) {
            int digit = (int) num % base;
            num /= base;
            convertedValue += digit * Math.pow(10, pow);
            pow++;
        }
        return convertedValue;
    }

    public static void main(String[] args) {
        int test1 = 1100; // base 2
        int expected1 = 12; // base 10
        int test2 = 172; //base 8
        /*int expected2 = 1172;
        int test3 = 10;
        int expected3 = 10;*/
        System.out.println(anyBaseToAnyBase(test1, 2, 10));
        System.out.println(anyBaseToAnyBase(test2, 8, 2));
/*        System.out.println(anyBaseToAnyBase(test2, 8));
        System.out.println(anyBaseToAnyBase(test3, 2));*/

    }
}
