package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.enums.MoveType;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private List<Point> path = new ArrayList<>();
    private Integer pathCost = 0;
    private MoveType moveType;

    public MoveResult() {}

    public void addToPath(Point point) {
        path.add(0, point);
        pathCost += point.getCost();
    }

    public int getPathCost() {
        return pathCost;
    }

    public List<Point> getPath() {
        return path;
    }

    public MoveType getMoveType() {
        return moveType;
    }
}
