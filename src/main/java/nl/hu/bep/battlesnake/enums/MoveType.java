package nl.hu.bep.battlesnake.enums;

public enum MoveType {
    NONE,
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public String toString() {
        return switch (this) {
            case UP -> "down";
            case DOWN -> "up";
            case LEFT -> "right";
            case RIGHT -> "left";
            default -> "none";
        };
    }
}
