package nl.hu.bep.battlesnake.model;

import nl.hu.bep.battlesnake.util.Calculator;

import java.util.ArrayList;
import java.util.Objects;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate() {}

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate getOffset(int offset) {
        return getOffset(offset, offset);
    }

    public Coordinate getOffset(int offsetX, int offsetY) {
        return new Coordinate(x + offsetX, y + offsetY);
    }

    public ArrayList<Coordinate> getOffsets(int minOffset, int maxOffset) {
        ArrayList<Coordinate> offsets = new ArrayList<>();
        offsets.add(getOffset(-minOffset));
        offsets.add(getOffset(maxOffset));
        return offsets;
    }

    public void flipX(int maxX) {
        int baseX = maxX / 2;
        this.x = Calculator.flipNum(baseX, this.x);
    }

    public void flipY(int maxY) {
        int baseY = maxY / 2;
        this.y = Calculator.flipNum(baseY, this.y);
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

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
