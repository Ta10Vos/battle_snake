package nl.hu.bep.battlesnake.map;

import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.model.*;

import java.util.ArrayList;

public class MapBuilder {
    Board board;
    ArrayList<ArrayList<BoardTile>> map =  new ArrayList<>();

    ArrayList<Coordinate> snakeHeads = new ArrayList<>();
    ArrayList<Coordinate> snakeBodies = new ArrayList<>();
    ArrayList<Coordinate> snakeTails = new ArrayList<>();

    ArrayList<Coordinate> foods = new ArrayList<>();
    ArrayList<Coordinate> hazards = new ArrayList<>();
    Battlesnake you;

    public MapBuilder(Board board, Battlesnake you, boolean generateFullMapNow) {
        this.board = board;
        this.foods = board.getFood();
        this.hazards = board.getHazards();
        this.you = you;
        generateSnakeMap(board.getSnakes());

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
            int lastIndex = snake.getBody().size() - 1;

            snakeHeads.add(body.get(0));
            snakeTails.add(body.get(lastIndex));

            body.remove(lastIndex);
            body.remove(0);
            snakeBodies.addAll(body);
        }
    }

    private BoardTile switchTile(BoardTile tile) {
        Coordinate c = tile.getCoordinate();

        if (foods.contains(c)) {
            tile.setTileType(TileType.FOOD);
            foods.remove(c);
        } else if (hazards.contains(c)) {
            tile.setTileType(TileType.HAZARD);
            hazards.remove(c);
        } else if (snakeHeads.contains(c)) {
            tile.setTileType(TileType.ENEMY_HEAD);
            snakeHeads.remove(c);
        } else if (snakeTails.contains(c)) {
            tile.setTileType(TileType.ENEMY_TAIL);
            snakeTails.remove(c);
        } else if (snakeBodies.contains(c)) {
            tile.setTileType(TileType.ENEMY_BODY);
            snakeBodies.remove(c);
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
            ArrayList<BoardTile> mapRow = new ArrayList<>();
            for(int i = 0; i < board.getWidth(); i++) {
                Coordinate coordinate = new Coordinate(i, j);
                BoardTile tile = new BoardTile(coordinate);
                mapRow.add(switchTile(tile));
            }
            map.add(mapRow);
        }

        logMap();
    }

    private void logMap() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<BoardTile> mapRow : map) {
            sb.append("[ ");
            for (BoardTile tile : mapRow) {
                sb.append(tile.getTileType());
                sb.append(" ");
            }

            sb.append(" ]\n");
        }
        System.out.println(sb.toString());
    }
}
