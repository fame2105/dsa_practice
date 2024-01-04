package design.lld.snakeAndLadder;


import design.lld.snakeAndLadder.strategies.AnyPlayerCrossesBoard;
import design.lld.snakeAndLadder.strategies.GameFinishCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * Requirements :
 * 1. 5 players including Computer, could be increased or decreased -> (Minor Changes required in addPlayers() in the Game class)
 * 2. Each player is assigned a piece of different color (player -> ID[unique], Name) -> DONE
 * 3. Board is of 10 X 10 size -> DONE
 * 4. 2 dice roll are used -> DONE
 * 5. Each player can start/open only after both the dice show 6 i.e dice roll value is 12 for the first time. -> (Done)
 * (Any player which crosses 100 on the board wins) -> Done
 */


public class Main {
    public static void main(String[] args) {
        int numOfPlayers = 5;
        List<Player> players = createPlayers(numOfPlayers);
        GameFinishCondition winningCondition = new AnyPlayerCrossesBoard(players);

        Game snakeAndLadder = new Game(10, 6, 5, 2, players, winningCondition);
        snakeAndLadder.startGame();
    }

    private static List<Player> createPlayers(int numOfPlayers) {
        List<Player> players = new ArrayList<>();
        for(int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player(String.valueOf(i), Game.PLAYER_START_POSITION));
        }

        return players;
    }
}
