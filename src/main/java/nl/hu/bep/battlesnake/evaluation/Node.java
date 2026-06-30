package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.Coordinate;
import nl.hu.bep.battlesnake.util.Calculator;

public class Node {
    public Node previous;
    public int x;
    public int y;

    private int gCost = 999;// cost of traveling to this Point. Make sure if set action is forgotten, it won't be "0"
    private int hCost;// estimated cost of the cheapest path from this to the goal

    public Node(Coordinate coordinate) {
        this.x = coordinate.x;
        this.y = coordinate.y;
    }

    public Node(int x, int y, Node previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    /**
     * Cost to this point (gCost) + Estimated cost to the goal (hCost)
     * @return
     */
    public int getFCost() {
        return gCost + hCost;
    }

    public int getGCost() {
        return gCost;
    }

    public void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(Node endGoal) {
        hCost = Calculator.manhattanDistance(this.x, this.y, endGoal.x, endGoal.y);
    }

    public Node getOffset(int offset) {
        return getOffset(offset, offset);
    }

    public Node getOffset(int offsetX, int offsetY) {
        return new Node(x + offsetX, y + offsetY, this);
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
