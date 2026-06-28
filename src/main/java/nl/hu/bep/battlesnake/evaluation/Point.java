package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.Coordinate;

public class Point extends Coordinate {
    public Point previous;

    public Point(int x, int y, Point previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    @Override
    public Point getOffset(int offset) {
        return getOffset(offset, offset);
    }

    @Override
    public Point getOffset(int offsetX, int offsetY) {
        return new Point(x + offsetX, y + offsetY, this);
    }
}
