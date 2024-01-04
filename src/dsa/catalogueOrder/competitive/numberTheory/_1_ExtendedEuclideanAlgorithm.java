package dsa.catalogueOrder.competitive.numberTheory;

public class _1_ExtendedEuclideanAlgorithm {
    private static class Pair {
        long x;
        long y;
        long gcd;

        public Pair(long x, long y, long gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static Pair extendedEuclid(long a, long b) {
        if(b == 0) {
            return new Pair(1, 0, a);
        }

        Pair dash = extendedEuclid(b, a%b);

        return new Pair(dash.y, dash.x - a/b*dash.y, dash.gcd);
    }

    public static void main(String[] args) {
        int a = 34;
        int b = 24;
        System.out.println(extendedEuclid(a, b));
    }
}
