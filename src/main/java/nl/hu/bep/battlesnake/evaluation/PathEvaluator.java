package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.model.battlesnake_API.Battlesnake;
import nl.hu.bep.battlesnake.model.battlesnake_API.Board;
import nl.hu.bep.battlesnake.model.requests.BaseGameRequest;

public class PathEvaluator {
    Board board;
    Battlesnake snake;

    public PathEvaluator(BaseGameRequest request) {
        this.board = request.board;
        this.snake = request.you;
    }


}
