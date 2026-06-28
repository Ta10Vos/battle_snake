package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.Coordinate;

public class Point extends Coordinate {
    public Point previous;
    private Integer cost;

    public Point(Coordinate coordinate) {
        super(coordinate.x, coordinate.y);
    }

    public Point(int x, int y, Point previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        if (this.cost != null) return;
        this.cost = cost;
    }

    @Override
    public Point getOffset(int offset) {
        return getOffset(offset, offset);
    }

    @Override
    public Point getOffset(int offsetX, int offsetY) {
        return new Point(x + offsetX, y + offsetY, this);
    }

    @Override
    public String toString() {
        return "Point{" +
                "y=" + y +
                ", x=" + x +
                ", cost=" + cost +
                '}';
    }
}
