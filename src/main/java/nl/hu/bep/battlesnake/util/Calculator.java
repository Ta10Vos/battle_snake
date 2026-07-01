package nl.hu.bep.battlesnake.util;

public class Calculator {
    /**
     * Estimate the distance to a certain point.
     * With currentX-goalX and currentY-goalY we can estimate to where we need to go.
     * @param currentX X of the current Node
     * @param currentY Y of the current Node
     * @param goalX X of the goal (distance to calculate to)
     * @param goalY Y of the goal (distance to calculate to)
     * @return Both results are added to each other to have the average distance of X and Y together.
     */
    public static int manhattanDistance(int currentX, int currentY, int goalX, int goalY) {
        int dx = currentX-goalX;
        int dy = currentY-goalY;
        return dx + dy;
    }

    /**
     * Flip a number around a base Number.
     * Example: baseNum of 5 and a numToFlip of 2. It will be flipped to 8,
     * because the distance to 5 is 3. Then we add the distance of 3 to the number and apply it to our numToFlip.
     * @param baseNum the middle of where the numToFlip should flip around.
     * @param numToFlip the number you want to flip around a baseNumber
     * @return
     */
    public static int flipNum(int baseNum, int numToFlip) {
        return 2 * baseNum - numToFlip;
    }
}
