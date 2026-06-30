package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.Coordinate;
import nl.hu.bep.battlesnake.util.Calculator;

public class Node extends Coordinate implements Comparable<Node> {
    public Node previous;

    private int gCost;// cost of traveling to this Point. Make sure if set action is not allocated yet, it won't be "0"
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

    public void setHCost(Node endGoal) {
        hCost = Calculator.manhattanDistance(this.x, this.y, endGoal.x, endGoal.y);
    }

    public Node getOffset(int offsetX, int offsetY) {
        return new Node(x + offsetX, y + offsetY, this);
    }

    /**
     * Compare this Node to the given Node.
     * @param other the object to be compared.
     * @return A value <0 if this.fCost is lower than the other Node.<br>
     * A value >0 if fCost is greater than other Node.<br>
     * Returns 0 if the other Node is null or if both are of equal values.
     */
    public int compareTo(Node other) {
        if (other == null) return 0;
        int fCompare = Integer.compare(getFCost(), other.getFCost());

        // If we do not have an equal situation
        if (fCompare != 0)
            return fCompare;

        // If we have an equal situation, find which Node is closer to the goal.
        return Integer.compare(hCost, other.hCost);
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
