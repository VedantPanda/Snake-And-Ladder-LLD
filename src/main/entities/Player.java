package main.entities;

public class Player {

    private final int id;

    private final String name;

    private int currentPosition;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
