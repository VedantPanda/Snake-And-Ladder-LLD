package main.entities;

import main.consts.SnakeLadderIdentifier;

import java.util.concurrent.ThreadLocalRandom;

import static main.utils.SnakeAndLadderUtils.getCell;

public class SnakeAndLadderBoard {

    private final Cell[][] board;

    public SnakeAndLadderBoard(int size, int noOfSnakes, int noOfLadders) {
        board = new Cell[size][size];
        initializeSnakeAndLadderOnBoard(noOfSnakes, noOfLadders);
    }

    private void initializeSnakeAndLadderOnBoard(int noOfSnakes, int noOfLadders) {
        initializeSnakeAndLadderOnBoardHelper(noOfSnakes, SnakeLadderIdentifier.SNAKE);
        initializeSnakeAndLadderOnBoardHelper(noOfLadders, SnakeLadderIdentifier.LADDER);
    }

    private void initializeSnakeAndLadderOnBoardHelper(int n, SnakeLadderIdentifier snakeLadderIdentifier) {
        while (n > 0){
            int start = ThreadLocalRandom.current().nextInt(1,board.length*board.length);
            int end = ThreadLocalRandom.current().nextInt(1,board.length*board.length);
            if(SnakeLadderIdentifier.SNAKE.equals(snakeLadderIdentifier) && start < end){
                continue;
            }
            if(SnakeLadderIdentifier.LADDER.equals(snakeLadderIdentifier) && start > end){
                continue;
            }
            Cell cell = getCell(start, board);
            if(cell==null){
                continue;
            }
            else{
                Jumper jumper = new Jumper(start, end, snakeLadderIdentifier);
                cell.setJumper(jumper);
            }
            n--;
        }
    }

    public Cell[][] getBoard() {
        return board;
    }
}
