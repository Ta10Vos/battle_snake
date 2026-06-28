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
    then that neighbor has higher priority.
     */
    neighbour_tiles,// Split section
    FOOD_NEIGHBOUR,//-10p
    ENEMY_HEAD_NEIGHBOUR,//50p
    ENEMY_BODY_NEIGHBOUR,//10p
    ENEMY_TAIL_NEIGHBOUR,//0p
    YOU_BODY_NEIGHBOUR,//15p
    YOU_TAIL_NEIGHBOUR;//10p

    public static boolean isNeighbor(TileType type) {
        return type.compareTo(TileType.neighbour_tiles) > 0;
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
            case FOOD_NEIGHBOUR -> -10;
            case ENEMY_HEAD_NEIGHBOUR -> 50;
            case ENEMY_BODY_NEIGHBOUR -> 10;
            case ENEMY_TAIL_NEIGHBOUR -> 0;
            case YOU_BODY_NEIGHBOUR -> 15;
            case YOU_TAIL_NEIGHBOUR -> 10;
            default -> 0;
        };
    }
}
