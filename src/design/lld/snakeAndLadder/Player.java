package design.lld.snakeAndLadder;

public class Player {
    String id;
    int currentPosition;
    boolean winner;

    boolean started; // denotes whether Player could begin playing his turn depending on he got 12 during any of his dice roll or not

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
        this.winner = false;
        this.started = false;
    }

    public boolean isWinner() {
        return this.winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
