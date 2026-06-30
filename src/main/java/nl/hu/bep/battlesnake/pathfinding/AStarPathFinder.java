package nl.hu.bep.battlesnake.pathfinding;

import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.evaluation.Node;
import nl.hu.bep.battlesnake.model.BoardMap;
import nl.hu.bep.battlesnake.model.Coordinate;

import java.util.*;

public class AStarPathFinder {
    private List<List<Integer>> costMap;
    private final Node[][] nodes;

    private final int minX = 0;
    private final int minY = 0;
    private final int maxX;
    private final int maxY;

    public AStarPathFinder(BoardMap map) {
        this.costMap = map.toCostMap();
        this.maxX = costMap.get(0).size() - 1;
        this.maxY = costMap.size() - 1;
        nodes = new Node[maxY + 1][maxX + 1];
        // Populate the nodes list
        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                nodes[y][x] = new Node(new Coordinate(x, y));
            }
        }
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

            if (current == null) {// If there's no more explorable Points
                return null;
            } else if (current.equals(end)) {// If we have reached the endGoal
                return constructPath(current);
            }
            // Add current Node to the explored nodes
            closedSet.add(current);

            for (Node neighbor : findNeighbors(current)) {
                // Do not visit already-explored neighbors
                if (closedSet.contains(neighbor)) continue;
                // Get the cost for moving to the neighboring Node
                int moveCost = current.getGCost() + costMap.get(neighbor.y).get(neighbor.x);
                // If moving to the neighbor is cheap enough or if we haven't explored the neighbor yet
                if (moveCost < neighbor.getGCost() || !openSet.contains(neighbor)) {
                    // Set neighbor variables
                    neighbor.setGCost(moveCost);
                    neighbor.setHCost(end);
                    neighbor.previous = current;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
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

    private List<Node> findNeighbors(Node current) {
        List<Node> neighbors = new ArrayList<>();

        // Get the values beforehand, so that we know we can use it to safely access a node
        int uY = current.y + 1;
        int dY = current.y - 1;
        int rX = current.x + 1;
        int lX = current.x - 1;

        if (uY <= maxY) {
            Node up = nodes[uY][current.x];
            if (canEnterTile(up)) neighbors.add(up);
        }
        if (dY >= minY) {
            Node down = nodes[dY][current.x];
            if (canEnterTile(down)) neighbors.add(down);
        }
        if (rX <= maxX) {
            Node right = nodes[current.y][rX];
            if (canEnterTile(right)) neighbors.add(right);
        }
        if (lX >= minX) {
            Node left = nodes[current.y][lX];
            if (canEnterTile(left)) neighbors.add(left);
        }

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
