package nl.hu.bep.model.requests;

import nl.hu.bep.model.Game;

public abstract class BaseGameRequest {
    Game game;
    int turn;
    Object board;
    Object you;
}
