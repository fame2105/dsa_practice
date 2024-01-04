package design.lld.random;

import java.util.concurrent.ThreadLocalRandom;

public class __3_UsingThreadLocalRandomClass {
    public static void main(String[] args) {

        // Generate random integers 0 to 49
        int rand1 = ThreadLocalRandom.current().nextInt(50);
        System.out.println("Random Integer between 0 to 49 : " + rand1);

        // Generate Random doubles values
        double rand2 = ThreadLocalRandom.current().nextDouble();
        System.out.println("Random double value : " + rand2);

        // Generate Random boolean value
        boolean rand3 = ThreadLocalRandom.current().nextBoolean();
        System.out.println("Random boolean value : " + rand3);

        // Generate Random Long value
        long rand4 = ThreadLocalRandom.current().nextLong();
        System.out.println("Random long value : " + rand4);

        // Generate Random doubles values
        double rand5 = ThreadLocalRandom.current().nextFloat();
        System.out.println("Random float value : " + rand5);
    }
}
