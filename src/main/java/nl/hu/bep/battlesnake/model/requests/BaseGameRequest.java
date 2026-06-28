package nl.hu.bep.battlesnake.model.requests;

import nl.hu.bep.battlesnake.model.battlesnake_API.Battlesnake;
import nl.hu.bep.battlesnake.model.battlesnake_API.Board;
import nl.hu.bep.battlesnake.model.battlesnake_API.Game;

public abstract class BaseGameRequest {
    public Game game;
    public int turn;
    public Board board;
    public Battlesnake you;
}
