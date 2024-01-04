package design.lld.snakeAndLadder;

/**
 * Jump Denotes a Snake or a Ladder
 * If startPosition is lesser than endPosition then jump behaves as a Ladder
 * If startPosition is greater than endPosition then jump behaves as a Snake
 */

public class Jump {
    int startPosition;
    int endPosition;

    public Jump(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}
