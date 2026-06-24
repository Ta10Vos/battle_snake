package nl.hu.bep.model.requests;

import nl.hu.bep.model.Game;

public abstract class BaseGameRequest {
    public Game game;
    public int turn;
    public Object board;
    public Object you;
}
