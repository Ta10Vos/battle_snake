package nl.hu.bep.battlesnake.model;

import java.util.Objects;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate() {}

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate that)) return false;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
