package nl.hu.bep.battlesnake.model.requests;

import nl.hu.bep.battlesnake.model.Battlesnake;
import nl.hu.bep.battlesnake.model.Board;
import nl.hu.bep.battlesnake.model.Game;

public abstract class BaseGameRequest {
    public Game game;
    public int turn;
    public Board board;
    public Battlesnake you;
}
