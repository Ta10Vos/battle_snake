package nl.hu.bep.battlesnake.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class BoardMap {
    private List<List<BoardTile>> map2D = new ArrayList<>();

    public BoardMap() {

    }

    public List<List<BoardTile>> get() {
        return map2D;
    }

    public void addRow(ArrayList<BoardTile> row) {
        this.map2D.add(row);
    }

    public void lockEditing() {
        for (int i = 0; i < this.map2D.size(); i++) {
            List<BoardTile> row = map2D.get(i);
            map2D.set(i, unmodifiableList(row));
        }
        this.map2D = unmodifiableList(this.map2D);
    }

    public BoardTile getBoardTile(Coordinate coordinate) {
        return getBoardTile(coordinate.y, coordinate.x);
    }

    public BoardTile getBoardTile(int y, int x) {
        return map2D.get(y).get(x);
    }

    public ArrayList<BoardTile> getAreaBoardTileList(Coordinate coordinate, int range) {
        ArrayList<BoardTile> result = new ArrayList<>();
        Coordinate minCoordinate = coordinate.getOffset(-range);
        Coordinate maxCoordinate = coordinate.getOffset(range);

        for (int i = minCoordinate.y; i <= maxCoordinate.y; i++) {
            for (int j = minCoordinate.x; j <= maxCoordinate.x; j++) {
                result.add(getBoardTile(i, j));
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
        return costMap;
    }
}
