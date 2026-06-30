package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.BoardMap;
import nl.hu.bep.battlesnake.model.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {
    private List<List<Integer>> costMap;

    private final int minX = 0;
    private final int minY = 0;
    private final int maxX;
    private final int maxY;

    public ShortestPath(BoardMap map) {
        this.costMap = map.toCostMap();
        this.maxX = costMap.get(0).size() - 1;
        this.maxY = costMap.size() - 1;
    }

    public MoveResult run(Coordinate start, Coordinate end) {
        Point startPoint = new Point(start);
        Point endPoint = new Point(end);

        MoveResult result = findPath(startPoint, endPoint);

        return result;
    }

    /**
     * A* algorithm, find a goal based on the points provided by the costMap.
     * Find the next available step that's available and not yet tried
     * @param start Starting point
     * @param end The goal coordinates we want to get to
     * @return MoveResult containing the path (full in previous chain) and the total cost of the path.
     */
    public MoveResult findPath(Point start, Point end) {
        PriorityQueue<Point> openSet = new PriorityQueue<>();
        HashSet<Point> closedSet = new HashSet<>();

        openSet.add(start);

        while (true) {
            Point current = openSet.poll();
            // If there's no more explorable Points
            if (current == null) return null;

            for (Point neighbor : findNeighbors(current)) {
                int moveCost = current.getGCost() + costMap.get(neighbor.y).get(neighbor.x);
                // If moving
                if (moveCost < neighbor.getGCost() || !openSet.contains(neighbor)) {
                    // Set neighbor variables
                    neighbor.setGCost(moveCost);
                    neighbor.setHCost(end);
                    neighbor.previous = current;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
                if (!closedSet.contains(neighbor) && !openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                }
            }

            // If we have explored all the neighbors,
            // mark all explored Points as closed, so that we don't visit them.
            for (Point point : openSet) {
                closedSet.add(point);
                // If we have reached the endGoal
                if (end.equals(point)) {
                    return constructPath(current);
                }
            }

            // If there is no more available path
            if (openSet.isEmpty()) {
                return new MoveResult(false);
            }
        }
    }

    private boolean canEnterTile(Point point) {
        if (point.y < minY || point.y > maxY) return false;
        if (point.x < minX || point.x > maxX) return false;
        return costMap.get(point.y).get(point.x) < 500;
    }

    private List<Point> findNeighbors(Point currPoint) {
        List<Point> neighbors = new ArrayList<>();
        Point up = currPoint.getOffset(0, 1);
        Point down = currPoint.getOffset(0, -1);
        Point right = currPoint.getOffset(1, 0);
        Point left = currPoint.getOffset(-1, 0);

        if (canEnterTile(up)) neighbors.add(up);
        if (canEnterTile(down)) neighbors.add(down);
        if (canEnterTile(right)) neighbors.add(right);
        if (canEnterTile(left)) neighbors.add(left);
        return neighbors;
    }

    private MoveResult constructPath(Point current) {
        MoveResult result = new MoveResult();
        // Walk through the points that have each other saved.
        while (current.previous != null) {
            result.addToPath(current);
            current = current.previous;
        }
        return result;
    }
}
