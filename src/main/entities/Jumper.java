package main.entities;

import main.consts.SnakeLadderIdentifier;

public class Jumper {
    private final int start;
    private final int end;

    private final SnakeLadderIdentifier snakeLadderIdentifier;

    public Jumper(int start, int end, SnakeLadderIdentifier snakeLadderIdentifier) {
        this.start = start;
        this.end = end;
        this.snakeLadderIdentifier = snakeLadderIdentifier;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public SnakeLadderIdentifier getSnakeLadderIdentifier() {
        return snakeLadderIdentifier;
    }
}
