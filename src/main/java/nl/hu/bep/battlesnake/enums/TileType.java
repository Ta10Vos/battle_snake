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
    ENEMY_BODY,//100p
    ENEMY_TAIL,//10p
    // Friendly snakes
    FRIENDLY_HEAD,//{HAZARD}p
    FRIENDLY_BODY,//{HAZARD}p
    FRIENDLY_TAIL,//{HAZARD}p
    // You
    YOU_HEAD,//100p
    YOU_BODY,//100p
    YOU_TAIL,//20p
}
