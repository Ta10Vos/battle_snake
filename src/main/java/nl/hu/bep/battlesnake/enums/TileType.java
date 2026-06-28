package nl.hu.bep.battlesnake.enums;

public enum TileType {
    // Map Tiles
    NONE,// 0p
    EMPTY,//5p
    WALL,//100p
    FOOD,//-20p
    HAZARD,//15p
    ENEMY_HEAD,//100p
    ENEMY_BODY,//100p
    ENEMY_TAIL,//10p
    // Enemy snake neighboring tiles. They
    // Friendly snakes
    FRIENDLY_HEAD,//{HAZARD}p
    FRIENDLY_BODY,//{HAZARD}p
    FRIENDLY_TAIL,//{HAZARD}p
    // You
    YOU_HEAD,//100p
    YOU_BODY,//100p
    YOU_TAIL,//4p
    /* Split section to know where neighbors are.
    If a neighbor has a lower value than the neighbor it gets compared against,
    then the current neighbor has higher priority.
     */
    neighbor_tiles,// Split section
    FOOD_NEIGHBOR,//-10p
    ENEMY_HEAD_NEIGHBOR,//50p
    ENEMY_BODY_NEIGHBOR,//10p
    ENEMY_TAIL_NEIGHBOR,//0p
    YOU_BODY_NEIGHBOR,//15p
    YOU_TAIL_NEIGHBOR;//10p

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

    public static int getCost(TileType type) {
        return switch (type) {
            case EMPTY -> 5;
            case WALL, ENEMY_HEAD, ENEMY_BODY, YOU_HEAD, YOU_BODY -> 100;
            case FOOD -> -10;
            case HAZARD -> 15;
            case ENEMY_TAIL -> 10;
            case FRIENDLY_HEAD, FRIENDLY_BODY -> 15;//hazard score
            case FRIENDLY_TAIL -> 15;//hazard score
            case YOU_TAIL -> 20;
            case FOOD_NEIGHBOR -> -10;
            case ENEMY_HEAD_NEIGHBOR -> 50;
            case ENEMY_BODY_NEIGHBOR -> 10;
            case ENEMY_TAIL_NEIGHBOR -> 0;
            case YOU_BODY_NEIGHBOR -> 15;
            case YOU_TAIL_NEIGHBOR -> 10;
            default -> 0;
        };
    }
}
