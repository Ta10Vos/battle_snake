package nl.hu.bep.battlesnake.model.requests;

import nl.hu.bep.battlesnake.model.Game;

public abstract class BaseGameRequest {
    public Game game;
    public int turn;
    public Object board;
    public Object you;
}
