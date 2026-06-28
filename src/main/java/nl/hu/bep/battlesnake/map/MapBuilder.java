package nl.hu.bep.battlesnake.map;

import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.model.*;

import java.util.ArrayList;

public class MapBuilder {
    Board board;
    BoardMap map = new BoardMap();

    ArrayList<Coordinate> snakeHeads;
    ArrayList<Coordinate> snakeBodies;
    ArrayList<Coordinate> snakeTails;

    Coordinate youTail;

    ArrayList<Coordinate> foods;
    ArrayList<Coordinate> hazards;
    Battlesnake you;

    public MapBuilder(Board board, Battlesnake you, boolean generateFullMapNow) {
        initiateProperties(board, you);

        if (generateFullMapNow) generate();
    }

    private void initiateProperties(Board board, Battlesnake you) {
        snakeHeads = new ArrayList<>();
        snakeBodies = new ArrayList<>();
        snakeTails = new ArrayList<>();
        foods = new ArrayList<>();
        hazards = new ArrayList<>();

        this.board = board;
        this.foods = board.getFood();
        this.hazards = board.getHazards();
        this.you = you;
        generateSnakeMap(board.getSnakes());
    }

    /**
     * Generate the snakeHeads, snakeBodies and snakeTails coordinates.
     * @param snakes The list of all Battlesnakes
     */
    private void generateSnakeMap(ArrayList<Battlesnake> snakes) {
        for (Battlesnake snake : snakes) {
            ArrayList<Coordinate> body = snake.getBody();
            int lastIndex = snake.getBody().size() - 1;

            // We only need to save the tail
            if (snake.getHead().equals(you.getHead())) {
                youTail = body.get(lastIndex);
                continue;
            }

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
        } else if (c.equals(you.getHead())) {
            tile.setTileType(TileType.YOU_HEAD);
        } else if (c.equals(youTail)) {
            tile.setTileType(TileType.YOU_TAIL);
        } else if (you.getBody().contains(c)) {
            tile.setTileType(TileType.YOU_BODY);
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
            map.addRow(mapRow);
        }

        logMap();
    }

    public void generateNeighbours() {
        initiateProperties(board, you);

        for(int j = 0; j < board.getHeight(); j++) {}
    }

    private void logMap() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<BoardTile> mapRow : map.get()) {
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
