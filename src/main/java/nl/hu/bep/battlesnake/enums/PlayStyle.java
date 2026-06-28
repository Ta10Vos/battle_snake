package nl.hu.bep.battlesnake.enums;

public enum PlayStyle {
    /**
     * Assign more points on:
     * - Empty spaces (3x3) around other snake heads
     * - Empty spaces (5x5) around food where other snake heads are near
     * Assign less points on:
     * - Empty spaces (5x5) around other snake tails
     * - Empty spaces (3x3) around snake bodies
     * - Empty spaces (3x3) around food
     */
    DEFENSIVE,
    /**
     * Assign less points on:
     * - Food
     * - Empty spaces (3x3) around other snake bodies
     */
    NEUTRAL,
    /**
     * Assign less points on:
     * Empty spaces (5x5) around other snake heads, closer (3x3) is even less points
     * Empty spaces (5x5) around other snake bodies, closer (3x3) is a bit more
     */
    OFFENSIVE // Start targeting snake heads, assign less points to snake bodies
}
