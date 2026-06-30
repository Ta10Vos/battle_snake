package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.BoardMap;
import nl.hu.bep.battlesnake.model.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class ShortestPath {
    private BoardMap map;
    private List<List<Integer>> costMap;
    private List<Coordinate> walkedPath;
    private List<Coordinate> outPath;

    private final int minX = 0;
    private final int minY = 0;
    private int maxX;
    private int maxY;

    public ShortestPath(BoardMap map) {
        this.map = map;
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
     * Very simple algorithm:
     * Find the next available step that's available and not yet tried
     * @param start Starting point
     * @param end The goal coordinates we want to get to
     * @return MoveResult containing the path and the total cost of the path.
     */
    public MoveResult findPath(Point start, Point end) {
        boolean finished = false;
        List<Point> used = new ArrayList<>();
        used.add(start);

        while (!finished) {
            List<Point> newOpen = new ArrayList<>();
            for (int i = 0; i < used.size(); i++) {
                Point point = used.get(i);
                for (Point neighbor : findNeighbors(point)) {
                    if (!used.contains(neighbor) && !newOpen.contains(neighbor)) {
                        newOpen.add(neighbor);
                    }
                }
            }

            // If we have reached the goal
            for (Point point : newOpen) {
                used.add(point);
                if (end.equals(point)) {
                    finished = true;
                    break;
                }
            }

            // If there is no more available path
            if (!finished && newOpen.isEmpty()) {
                return null;
            }
        }

        MoveResult result = new MoveResult();
        Point point = used.get(used.size() - 1);
        // Walk through the points that have each other saved.
        while (point.previous != null) {
            point.setCost(costMap.get(point.y).get(point.x));
            result.addToPath(point);
            point = point.previous;
        }
        return result;
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
}
