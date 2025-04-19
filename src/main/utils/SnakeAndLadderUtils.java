package main.utils;

import main.entities.Cell;

public class SnakeAndLadderUtils {

    public static Cell getCell(int start, Cell[][] board) {
        int row = start/board.length;
        int col = start%board.length;
        Cell cell = board[row][col];
        if(cell!=null && cell.getJumper()!=null){
            return null;
        }
        else{
            return board[row][col] = new Cell();
        }
    }

}
