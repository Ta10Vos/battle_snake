package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.enums.MoveType;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private List<Node> path = new ArrayList<>();
    private Integer pathCost = 0;
    private MoveType moveType;

    public MoveResult() {}

    /**
     * Create a MoveResult with the success status.
     * @param success Give a success state. If set to false, all values will be set to high values to make this Move undesirable.
     */
    public MoveResult(boolean success) {
        if (!success) {
            pathCost = Integer.MAX_VALUE;
            moveType = MoveType.NONE;
        }
    }

    public void addToPath(Node node) {
        path.add(0, node);
    }

    public void setPathCost(Integer pathCost) {
        this.pathCost = pathCost;
    }

    public int getPathCost() {
        return pathCost;
    }

    public List<Node> getPath() {
        return path;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void calculateMoveType() {
        if (path.size() <= 1) return;

        Node start = path.get(0);
        Node next = path.get(1);

        if (next.y < start.y) moveType = MoveType.UP;
        else if (next.y > start.y) moveType = MoveType.DOWN;
        else if (next.x < start.x) moveType = MoveType.LEFT;
        else if (next.x > start.x) moveType = MoveType.RIGHT;
    }
}
