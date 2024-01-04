package dsa.catalogueOrder.foundation.array;

public class DecimalToAnyBase {

    private static long decimalToAnyBase(int num, int base) {
        long convertedValue = 0l;
        int pow = 0;
        while (num != 0) {
            int digit = num % base;
            num /= base;
            convertedValue += digit * Math.pow(10, pow);
            pow++;
        }
        return convertedValue;
    }

    public static void main(String[] args) {
        int test1 = 62;
        int test2 = 634;
        int test3 = 13;
//        System.out.println(decimalToAnyBase(test1, 8));
//        System.out.println(decimalToAnyBase(test2, 8));
        System.out.println(decimalToAnyBase(test3, 2));

    }
}
