package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;
import java.util.Objects;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate() {}

    public Coordinate(int x, int y) {
        this.x = Math.max(x, 0);
        this.y = Math.max(y, 0);
    }

    public Coordinate getOffset(int offset) {
        return new Coordinate(x + offset, y + offset);
    }

    public ArrayList<Coordinate> getOffsets(int minOffset, int maxOffset) {
        ArrayList<Coordinate> offsets = new ArrayList<>();
        offsets.add(getOffset(-minOffset));
        offsets.add(getOffset(maxOffset));
        return offsets;
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
