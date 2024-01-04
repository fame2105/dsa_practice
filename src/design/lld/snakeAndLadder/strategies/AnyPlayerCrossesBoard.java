package design.lld.snakeAndLadder.strategies;

import design.lld.snakeAndLadder.Player;

import java.util.List;

public class AnyPlayerCrossesBoard implements GameFinishCondition {
    List<Player> players;

    public AnyPlayerCrossesBoard(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean isGameFinished() {
        for (Player player : this.players) {
            if(player.isWinner())
                return true;
        }

        return false;
    }
}


