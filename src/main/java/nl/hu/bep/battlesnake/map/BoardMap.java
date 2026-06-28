package nl.hu.bep.battlesnake.map;

import nl.hu.bep.battlesnake.model.BoardTile;
import nl.hu.bep.battlesnake.model.Coordinate;

import java.util.ArrayList;

public class BoardMap {
    ArrayList<ArrayList<BoardTile>> map2D = new ArrayList<>();

    public BoardMap() {

    }

    public ArrayList<ArrayList<BoardTile>> get() {
        return map2D;
    }

    public void set(ArrayList<ArrayList<BoardTile>> map2D) {
        this.map2D = map2D;
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
}
