package nl.hu.bep.battlesnake.model;

import nl.hu.bep.battlesnake.enums.TileType;

public class BoardTile {
    /** The position of this tile */
    private Coordinate coordinate;
    /** How much risk is going to this tile? */
    private int cost = 0;
    /** What type of tile is this? */
    private TileType tileType = TileType.NONE;

    public BoardTile(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }
}
