package design.lld.snakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    int boardSize;
    Cell[][] cells;

    int numberOfSnakes;

    int numberOfLadders;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        this.boardSize = boardSize;
        this.numberOfSnakes = numberOfSnakes;
        this.numberOfLadders = numberOfLadders;
        this.cells = new Cell[boardSize][boardSize];

        initializeCells();
        addSnakesAndLaddersOnBoard();
    }

    private void initializeCells() {
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    private void addSnakesAndLaddersOnBoard() {
        int numberOfSnakesAdded = 0;
        while(numberOfSnakesAdded < this.numberOfSnakes) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, this.boardSize * this.boardSize - 1); // on a 10 x 10 board 99 is the destination value for winning the game... and we wouldn't want any ladder or snake to be present at the destination value
            int snakeTail = ThreadLocalRandom.current().nextInt(1, this.boardSize * this.boardSize - 1);

            if(snakeTail >= snakeHead)
                continue;

            Jump jump = new Jump(snakeHead, snakeTail);

            Cell cell = getCell(snakeHead);
            cell.jump = jump;

            numberOfSnakesAdded++;
        }

        int numberOfLaddersAdded = 0;
        while(numberOfLaddersAdded < this.numberOfLadders) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, this.boardSize * this.boardSize);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, this.boardSize * this.boardSize);

            if(ladderStart >= ladderEnd)
                continue;

            Jump jump = new Jump(ladderStart, ladderEnd);

            Cell cell = getCell(ladderStart);
            cell.jump = jump;

            numberOfLaddersAdded++;
        }
    }

    public Cell getCell(int snakeHead) {
        int boardRow = snakeHead / this.boardSize;
        int boardCol = snakeHead % this.boardSize;
        return cells[boardRow][boardCol];
    }


}
