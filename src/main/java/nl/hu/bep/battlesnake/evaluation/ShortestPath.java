package nl.hu.bep.battlesnake.evaluation;

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
        this.maxX = costMap.getFirst().size() - 1;
        this.maxY = costMap.size() - 1;
    }

    public MoveResult run(Coordinate start, Coordinate end) {
        Point start = new Point(start.);

    }

    public List<Point> findPath(Point start, Point end) {
        boolean finished = false;
        List<Point> used =  new ArrayList<>();
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
