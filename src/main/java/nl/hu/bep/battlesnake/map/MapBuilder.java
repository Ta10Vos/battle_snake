package nl.hu.bep.battlesnake.map;

import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.model.*;

import java.util.ArrayList;

public class MapBuilder {
    ArrayList<ArrayList<Coordinate>> map;

    ArrayList<Coordinate> snakeHeads = new ArrayList<>();
    ArrayList<Coordinate> snakeBodies = new ArrayList<>();
    ArrayList<Coordinate> snakeTails = new ArrayList<>();

    ArrayList<Coordinate> foods = new ArrayList<>();
    ArrayList<Coordinate> hazards = new ArrayList<>();
    Battlesnake you;

    public MapBuilder(Board board, Battlesnake you, boolean generateFullMapNow) {
        generateSnakeMap(board.getSnakes());
        this.foods = board.getFood();
        this.hazards = board.getHazards();
        this.you = you;

        if (generateFullMapNow) generate();
    }

    /**
     * Generate the snakeHeads, snakeBodies and snakeTails coordinates.
     * @param snakes The list of all Battlesnakes
     */
    private void generateSnakeMap(ArrayList<Battlesnake> snakes) {
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

    private BoardTile switchTile(BoardTile tile) {
        Coordinate c = tile.getCoordinate();

        if (foods.contains(c)) {
            tile.setTileType(TileType.FOOD);
        } else if (hazards.contains(c)) {
            tile.setTileType(TileType.HAZARD);
        } else if (snakeHeads.contains(c)) {
            tile.setTileType(TileType.ENEMY_HEAD);
        } else if (snakeTails.contains(c)) {
            tile.setTileType(TileType.ENEMY_TAIL);
        } else if (snakeBodies.contains(c)) {
            tile.setTileType(TileType.ENEMY_BODY);
        } else {
            tile.setTileType(TileType.EMPTY);
        }

        return tile;
    }

    /**
     * Create the map based off the Board and "you" Battlesnake object
     */
    public void generate() {
        for(int j = 0; j < board.getHeight(); j++) {
            ArrayList<Coordinate> mapRow = new ArrayList<>();
            for(int i = 0; i < board.getWidth(); i++) {
                Coordinate coordinate = new Coordinate(i, j);
                mapRow.add(switchTile(coordinate));
            }
        }
    }
}
