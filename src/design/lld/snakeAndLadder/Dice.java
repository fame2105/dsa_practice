package design.lld.snakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int min;
    int max;

    public Dice(int diceCount) { // diceCount denotes number of dices that are being used in the game
        this.diceCount = diceCount;
        this.min = 1;
        this.max = 6;
    }

    public int rollDice() {
        int countRollDice = 0;
        int val = 0;

        while (countRollDice < this.diceCount) {
            val += ThreadLocalRandom.current().nextInt(min, max + 1); // outerBound is exclusive, which is why we do +1 in max
            countRollDice += 1;
        }

//        try {
//            // Sleeping for 500 milliseconds for Reading Console Logs Generation after each Dice Roll
//            Thread.sleep(500l);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        return val;
    }
}
