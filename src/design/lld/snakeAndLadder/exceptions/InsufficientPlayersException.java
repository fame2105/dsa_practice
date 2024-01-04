package design.lld.snakeAndLadder.exceptions;

public class InsufficientPlayersException extends RuntimeException {

    public InsufficientPlayersException() {
        super("Insufficient Players Available");
    }
}
