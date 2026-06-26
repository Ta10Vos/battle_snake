package nl.hu.bep.battlesnake.map;

import nl.hu.bep.battlesnake.model.*;

import java.util.ArrayList;

public class MapBuilder {
    Board board;
    ArrayList<Coordinate> snakeHeads = new ArrayList<>();
    ArrayList<Coordinate> snakeBodies =  new ArrayList<>();
    ArrayList<Coordinate> snakeTails =  new ArrayList<>();

    ArrayList<Coordinate> foods;
    ArrayList<Coordinate> hazards;
    Battlesnake you;

    public MapBuilder(Board board, Battlesnake you, boolean generateFullMapNow) {
        generateSnakeMap(board.getSnakes(), you);
    }

    /**
     * Generate the snakeHeads, snakeBodies and snakeTails coordinates.
     * @param snakes The list of all Battlesnakes
     * @param you The "you" Battlesnake
     */
    private void generateSnakeMap(ArrayList<Battlesnake> snakes, Battlesnake you) {
        for (Battlesnake snake : snakes) {
            if (snake.getHead().equals(you.getHead())) continue;

            ArrayList<Coordinate> body = snake.getBody();

            snakeHeads.add(body.get(0));
            snakeTails.add(body.get(snake.getLength()));

            body.remove(snake.getLength());
            body.remove(0);
            snakeBodies.addAll(body);
        }
    }
    
    private BoardTile switchTile(Coordinate c) {
        BoardTile tile = new BoardTile(c);

    }

    /**
     * Create the map based off the Board and "you" Battlesnake object
     */
    public void generate() {
        for(int j = 0; j < board.getHeight(); j++) {
            for(int i = 0; i < board.getWidth(); i++) {
                Coordinate coordinate = new Coordinate(i, j);
                BoardTile tile = new BoardTile();
            }
        }
    }
}
