package main.entities;

import main.BoardGames;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import static main.utils.SnakeAndLadderUtils.getCell;

public class SnakeAndLadderGame implements BoardGames {

    private final Scanner scanner;

    private final SnakeAndLadderBoard snakeAndLadderBoard;

    private final Deque<Player> players;

    private final Dice dice;

    private Player winner;

    public SnakeAndLadderGame() {
        scanner = new Scanner(System.in);
        int boardSize = initializeBoardSize();
        int noOfSnakes;
        int noOfLadders;
        while (true){
            System.out.println("Enter the number of snakes");
            noOfSnakes = scanner.nextInt();
            System.out.println("Enter the number of ladders");
            noOfLadders = scanner.nextInt();
            if(noOfSnakes+noOfLadders>boardSize){
                System.out.println("No of snakes and ladders combined "+noOfLadders+noOfSnakes+" exceed the size of the board "+boardSize);
                System.out.println("Try Again...");
            }
            else{
                break;
            }
        }
        snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize, noOfSnakes, noOfLadders);
        dice = new Dice(getNoOfDice());
        players = new LinkedList<>();
        initializePlayers();
    }

    private int getNoOfDice() {
        int noOfDice;
        while (true){
            System.out.println("Enter the number of dice");
            noOfDice = scanner.nextInt();
            if(noOfDice < 1){
                System.out.println("Number of dice has to be at least 1");
                continue;
            }
            return noOfDice;
        }
    }

    private int initializeBoardSize(){
        int boardSize;
        while (true){
            System.out.println("Enter the size of the board");
            boardSize = scanner.nextInt();
            if(boardSize < 1){
                System.out.println("Size of the board should be greater than 0");
            }
            else{
                break;
            }
        }
        return boardSize;
    }

    private void initializePlayers() {
        int noOfPlayers;
        while(true){
            System.out.println("Enter the total number of players");
            noOfPlayers = scanner.nextInt();
            if(noOfPlayers<=0){
                System.out.println("Number of players have to be at least 1");
            }
            else{
                break;
            }
        }
        initializePlayersHelper(noOfPlayers);
    }

    private void initializePlayersHelper(int noOfPlayers) {
        int serialNo = 1;
        while (noOfPlayers > 0){
            System.out.println("Enter Player "+serialNo+" name");
            String name = scanner.next();
            players.addLast(new Player(serialNo, name));
            noOfPlayers--;
            serialNo++;
        }
    }


    @Override
    public void play() {
        while (winner == null){
            Player currPlayer = players.removeFirst();
            int newPosition = currPlayer.getCurrentPosition() + dice.rollDice();
            Cell cell = getCell(newPosition, snakeAndLadderBoard.getBoard());
            if(cell!=null && cell.getJumper()!=null && newPosition==cell.getJumper().getStart()){
                currPlayer.setCurrentPosition(cell.getJumper().getEnd());
            }
            else{
                currPlayer.setCurrentPosition(newPosition);
            }
            int boardSize = snakeAndLadderBoard.getBoard().length;
            if(currPlayer.getCurrentPosition()==boardSize*boardSize){
                winner = currPlayer;
            }
            else{
                players.addLast(currPlayer);
            }
        }
        announceResult();
    }

    private void announceResult() {
        System.out.println("Winner is "+winner.getName()+" id "+winner.getId());
    }
}
