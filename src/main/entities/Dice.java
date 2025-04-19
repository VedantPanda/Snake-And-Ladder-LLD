package main.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private final int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int rollDice(){
        int totalDice = noOfDice;
        int totalSum = 0;
        while (totalDice > 0){
            totalSum+= ThreadLocalRandom.current().nextInt(1,7);
            totalDice--;
        }
        return totalSum;
    }

}
