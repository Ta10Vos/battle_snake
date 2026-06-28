package nl.hu.bep.battlesnake.enums;

public enum MoveType {
    NONE,
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public String toString() {
        return switch (this) {
            case UP -> "up";
            case DOWN -> "down";
            case LEFT -> "left";
            case RIGHT -> "right";
            default -> "none";
        };
    }
}
