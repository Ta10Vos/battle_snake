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
        this.cost = TileType.getCost(tileType);
    }

    public void replaceType(TileType type) {
        replaceType(type, false);
    }

    public void replaceType(TileType type, boolean force) {
        if (!force) {
            // Neighbors can overwrite each other based on priority
            if (TileType.isNeighbor(type)) {
                if (TileType.isNeighbor(tileType)) {
                    // Lower number = higher priority: Overwrite
                    if (type.hasPriorityOver(tileType)) force = true;
                }
            }

            if (tileType != TileType.EMPTY && !force) {// Can only overwrite empty tiles
                return;
            }
        }

        setTileType(type);
    }
}
