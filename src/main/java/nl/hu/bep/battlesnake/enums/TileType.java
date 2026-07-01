package nl.hu.bep.battlesnake.enums;

public enum TileType {
    // Map Tiles
    NONE,
    EMPTY,
    WALL,
    FOOD,
    HAZARD,
    ENEMY_HEAD,
    ENEMY_BODY,
    ENEMY_TAIL,
    // Enemy snake neighboring tiles. They
    // Friendly snakes
    FRIENDLY_HEAD,
    FRIENDLY_BODY,
    FRIENDLY_TAIL,
    // You
    YOU_HEAD,
    YOU_BODY,
    YOU_TAIL,
    /* Split section to know where neighbors are.
    If a neighbor has a lower value than the neighbor it gets compared against,
    then the current neighbor has higher priority.
     */
    neighbor_tiles,// Split section
    FOOD_NEIGHBOR,
    ENEMY_HEAD_NEIGHBOR,
    ENEMY_BODY_NEIGHBOR,
    ENEMY_TAIL_NEIGHBOR,
    YOU_BODY_NEIGHBOR,
    YOU_TAIL_NEIGHBOR,
    FRIENDLY_HEAD_NEIGHBOR,
    FRIENDLY_BODY_NEIGHBOR,
    FRIENDLY_TAIL_NEIGHBOR;

    public static boolean isNeighbor(TileType type) {
        return type.compareTo(TileType.neighbor_tiles) > 0;
    }

    /**
     * See whether the current TileType has priority over the given TileType
     * @param type the type you're comparing against.
     * @return boolean indicating whether the current type has a higher priority
     * (lower number) than the given type.
     */
    public boolean hasPriorityOver(TileType type) {
        return this.compareTo(type) < 0;
    }

    /**
     * The baseline cost of all tiles. Edit these values in specific PlayStyle modes.
     * @param type The type of the Tile you're getting the cost from.
     * @return The point cost of the TileType
     */
    public static int getCost(TileType type) {
        return switch (type) {
            case EMPTY -> 3;
            case WALL, ENEMY_BODY, YOU_HEAD, YOU_BODY, YOU_TAIL -> 1000;
            case ENEMY_HEAD -> 1000;
            case FOOD -> 1;
            case HAZARD -> 5;
            case ENEMY_TAIL -> 2;
            case FRIENDLY_HEAD, FRIENDLY_BODY -> 2;
            case FRIENDLY_TAIL -> 4;
            case FOOD_NEIGHBOR -> 2;
            case ENEMY_HEAD_NEIGHBOR -> 10;
            case ENEMY_BODY_NEIGHBOR -> 5;
            case ENEMY_TAIL_NEIGHBOR -> 2;
            case YOU_BODY_NEIGHBOR -> 2;
            case YOU_TAIL_NEIGHBOR -> 2;
            default -> 0;
        };
    }
}
