package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.Coordinate;
import nl.hu.bep.battlesnake.util.Calculator;

public class Point {
    public Point previous;
    public int x;
    public int y;

    public int gCost = 1000;// cost of traveling to this Point
    public int hCost;// estimated cost of the cheapest path from this to the goal

    public Point(Coordinate coordinate) {
        this.x = coordinate.x;
        this.y = coordinate.y;
    }

    public Point(int x, int y, Point previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    public int getFCost() {
        return gCost + hCost;
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public int getGCost() {
        return gCost;
    }

    public void setGCost(Point endGoal) {
        gCost = Calculator.manhattanDistance(this.x, this.y, endGoal.x, endGoal.y);
    }

    public Point getOffset(int offset) {
        return getOffset(offset, offset);
    }

    public Point getOffset(int offsetX, int offsetY) {
        return new Point(x + offsetX, y + offsetY, this);
    }

    @Override
    public String toString() {
        return "Point{" +
                "previous=" + previous +
                ", gCost=" + gCost +
                ", hCost=" + hCost +
                ", fCost=" + getFCost() +
                '}';
    }
}
