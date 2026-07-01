package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class BoardMap {
    private List<List<BoardTile>> map2D = new ArrayList<>();
    private final int minX = 0;
    private final int minY = 0;
    private int maxX = 0;
    private int maxY = 0;

    public BoardMap() {

    }

    public List<List<BoardTile>> get() {
        return map2D;
    }

    /**
     * Add a row to the map
     * @param row The row to add to the map
     */
    public void addRow(ArrayList<BoardTile> row) {
        // Y-index is mirrored. Push it in index 0.
        this.map2D.add(row);
    }

    public void lockEditing() {
        for (int i = 0; i < this.map2D.size(); i++) {
            List<BoardTile> row = map2D.get(i);
            map2D.set(i, unmodifiableList(row));
        }
        this.map2D = unmodifiableList(this.map2D);
        maxX = map2D.get(0).size() - 1;
        maxY = map2D.size() - 1;
    }

    public BoardTile getBoardTile(int y, int x) {
        return map2D.get(y).get(x);
    }

    public ArrayList<BoardTile> getAreaBoardTileList(Coordinate coordinate, int range) {
        ArrayList<BoardTile> result = new ArrayList<>();
        Coordinate minCoordinate = coordinate.getOffset(-range);
        Coordinate maxCoordinate = coordinate.getOffset(range);

        for (int y = minCoordinate.y; y <= maxCoordinate.y; y++) {
            for (int x = minCoordinate.x; x <= maxCoordinate.x; x++) {
                if (x < 0 || x > maxX) continue;
                if (y < 0 || y > maxY) continue;
                result.add(getBoardTile(y, x));
            }
        }

        return result;
    }

    public List<List<Integer>> toCostMap() {
        List<List<Integer>> costMap = new ArrayList<>();
        for (List<BoardTile> row : map2D) {
            List<Integer> costRow = new ArrayList<>();
            row.forEach(t -> costRow.add(t.getCost()));
            costMap.add(costRow);
        }
        System.out.println("GENERATED COSTMAP");
        for (List<Integer> row : costMap) {
            System.out.println(row);
        }
        return costMap;
    }
}
