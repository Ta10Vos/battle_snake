package nl.hu.bep.battlesnake.util;

public class Calculator {
    public static int manhattanDistance(int xCurrent, int yCurrent, int xGoal, int yGOal) {
        int dx = xCurrent-xGoal;
        int dy = yCurrent-yGOal;
        return dx + dy;
    }
}
