package nl.hu.bep.battlesnake.enums;

public enum TileType {
    // Map Tiles
    NONE,// 0p
    EMPTY,//5p
    WALL,//100p
    FOOD,//-10p
    HAZARD,//15p
    // Enemy snakes
    ENEMY_HEAD,//100p
    ENEMY_BODY,//75p
    ENEMY_TAIL,//20p
    // Friendly snakes
    FRIENDLY_HEAD,//{EMPTY}p
    FRIENDLY_BODY,//{EMPTY}p
    FRIENDLY_TAIL,//{EMPTY}p
    // You
    YOU_HEAD,//100p
    YOU_BODY,//100p
    YOU_TAIL,//30p
}
