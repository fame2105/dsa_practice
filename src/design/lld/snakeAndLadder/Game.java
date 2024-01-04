package design.lld.snakeAndLadder;

import design.lld.snakeAndLadder.exceptions.InsufficientPlayersException;
import design.lld.snakeAndLadder.strategies.GameFinishCondition;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {

    GameFinishCondition condition;
    Board board;
    Deque<Player> playerList;
    Dice dice;

    public static final int PLAYER_START_POSITION = 0;

    public Game(int boardSize, int numberOfSnakes, int numberOfLadders, int diceCount, List<Player> players, GameFinishCondition condition) {
        this.board = new Board(boardSize, numberOfSnakes, numberOfLadders);
        this.playerList = new LinkedList<>();
        this.dice = new Dice(diceCount);
        this.condition = condition;
        addPlayers(players);
    }

    private void addPlayers(List<Player> players) {
        if(players.size() < 1)
            throw new InsufficientPlayersException();

        for(Player player : players)
            playerList.add(player);
    }

    public void startGame() {
        Player winner = null; // Only for logging Needs.
        while (!condition.isGameFinished()) {
            // find player turn
            Player player = findPlayerTurn();
            System.out.println("Log[Info] " + "player turn is:" + player.id + " current position is: " + player.currentPosition);

            // roll dice
            int diceVal = dice.rollDice();

            // check whether this player could begin playing
            if(!player.started) {
                if(diceVal == 12)
                    player.started = true;
                else
                    continue;
            }

            // Get new value for this player based on dice value
            int playerNewPosition = player.currentPosition + diceVal;
            playerNewPosition = jumpCheck(playerNewPosition);
            System.out.println("Log[Info] -- from: " + player.currentPosition + " to: " + playerNewPosition);
            player.currentPosition = playerNewPosition;

            System.out.println("Log[Info] " + "player turn is:" + player.id + " new Position is: " + playerNewPosition);

            // Check if this player has fulfilled the condition to win the game.
            if (playerNewPosition >= board.boardSize * board.boardSize - 1) {
                player.winner = true;
                winner = player;
            }
        }

        System.out.println("WINNER is " + winner.id);
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.boardSize * board.boardSize - 1)
            return playerNewPosition;

        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && playerNewPosition == cell.jump.startPosition) {
            String jumpBy = cell.jump.startPosition > cell.jump.endPosition ? "Snake" : "Ladder"; // only for logging purpose
            System.out.println("Log[Info] -- jump done by: " + jumpBy);
            return cell.jump.endPosition; // player is going to be at the end position of this jump.
        }
        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player player = null;
        if (playerList.size() > 0)
            player = playerList.removeFirst();

        playerList.addLast(player);

        return player;
    }
}
