package nl.hu.bep.battlesnake.pathfinding;

import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.evaluation.Node;
import nl.hu.bep.battlesnake.model.BoardMap;
import nl.hu.bep.battlesnake.model.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStarPathFinder {
    private List<List<Integer>> costMap;

    private final int minX = 0;
    private final int minY = 0;
    private final int maxX;
    private final int maxY;

    public AStarPathFinder(BoardMap map) {
        this.costMap = map.toCostMap();
        this.maxX = costMap.get(0).size() - 1;
        this.maxY = costMap.size() - 1;
    }

    public MoveResult run(Coordinate start, Coordinate end) {
        Node startNode = new Node(start);
        Node endNode = new Node(end);

        MoveResult result = findPath(startNode, endNode);

        return result;
    }

    /**
     * A* algorithm, find a goal based on the points provided by the costMap.
     * Find the next available step that's available and not yet tried
     * @param start Starting point
     * @param end The goal coordinates we want to get to
     * @return MoveResult containing the path (full in previous chain) and the total cost of the path.
     */
    public MoveResult findPath(Node start, Node end) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        HashSet<Node> closedSet = new HashSet<>();

        openSet.add(start);

        while (true) {
            Node current = openSet.poll();
            // If there's no more explorable Points
            if (current == null) return null;

            for (Node neighbor : findNeighbors(current)) {
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
            for (Node node : openSet) {
                closedSet.add(node);
                // If we have reached the endGoal
                if (end.equals(node)) {
                    return constructPath(current);
                }
            }

            // If there is no more available path
            if (openSet.isEmpty()) {
                return new MoveResult(false);
            }
        }
    }

    private boolean canEnterTile(Node node) {
        if (node.y < minY || node.y > maxY) return false;
        if (node.x < minX || node.x > maxX) return false;
        return costMap.get(node.y).get(node.x) < 500;
    }

    private List<Node> findNeighbors(Node currNode) {
        List<Node> neighbors = new ArrayList<>();
        Node up = currNode.getOffset(0, 1);
        Node down = currNode.getOffset(0, -1);
        Node right = currNode.getOffset(1, 0);
        Node left = currNode.getOffset(-1, 0);

        if (canEnterTile(up)) neighbors.add(up);
        if (canEnterTile(down)) neighbors.add(down);
        if (canEnterTile(right)) neighbors.add(right);
        if (canEnterTile(left)) neighbors.add(left);
        return neighbors;
    }

    private MoveResult constructPath(Node current) {
        MoveResult result = new MoveResult();
        // Walk through the points that have each other saved.
        while (current.previous != null) {
            result.addToPath(current);
            current = current.previous;
        }
        return result;
    }
}
