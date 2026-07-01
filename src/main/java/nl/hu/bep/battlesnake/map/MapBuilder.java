package nl.hu.bep.battlesnake.map;

import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.model.*;
import nl.hu.bep.battlesnake.model.battlesnake_API.Battlesnake;
import nl.hu.bep.battlesnake.model.battlesnake_API.Board;

import java.util.ArrayList;
import java.util.List;

public class MapBuilder {
    private Board board;
    private BoardMap map = new BoardMap();

    private ArrayList<Coordinate> snakeHeads;
    private ArrayList<Coordinate> snakeBodies;
    private ArrayList<Coordinate> snakeTails;

    private Battlesnake you;
    private Coordinate youHead;
    private ArrayList<Coordinate> youBody;
    private Coordinate youTail;

    private ArrayList<Coordinate> foods;
    private ArrayList<Coordinate> hazards;

    boolean finished = false;

    public MapBuilder(Board board, Battlesnake you, boolean generateFullMapNow) {
        initiateProperties(board, you);

        // Flip all lists, so that we use the coordinates according to the battlesnake layout.
        // This way, we can make the right movements.
        flipAllLists();

        if (generateFullMapNow) generate();
    }

    private void initiateProperties(Board board, Battlesnake you) {
        snakeHeads = new ArrayList<>();
        snakeBodies = new ArrayList<>();
        youBody = new ArrayList<>();
        snakeTails = new ArrayList<>();
        foods = new ArrayList<>();
        hazards = new ArrayList<>();

        this.board = board;
        this.foods = new ArrayList<>(board.getFood());
        this.hazards = new ArrayList<>(board.getHazards());
        this.you = you;
        generateSnakeMap(board.getSnakes());
    }

    public BoardMap getMap() {
        return map;
    }

    /**
     * Generate the snakeHeads, snakeBodies and snakeTails coordinates.
     * @param snakes The list of all Battlesnakes
     */
    private void generateSnakeMap(List<Battlesnake> snakes) {
        for (Battlesnake snake : snakes) {
            ArrayList<Coordinate> body = new ArrayList<>(snake.getBody());
            int lastIndex = snake.getBody().size() - 1;

            // We only need to save the tail
            if (snake.getId().equals(you.getId())) {
                youHead = body.get(0);
                youTail = body.get(lastIndex);
                body.remove(lastIndex);
                body.remove(0);
                youBody = body;
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
        } else if (c.equals(youHead)) {
            tile.setTileType(TileType.YOU_HEAD);
        } else if (c.equals(youTail)) {
            tile.setTileType(TileType.YOU_TAIL);
        } else if (youBody.contains(c)) {
            tile.setTileType(TileType.YOU_BODY);
        } else {
            tile.setTileType(TileType.EMPTY);
        }

        return tile;
    }

    public void generate() {
        buildMap();
        generateNeighbours();
        map.lockEditing();
//        MapBuilder.logMap(map);
        finished = true;
    }

    /**
     * Create the map based off the Board and "you" Battlesnake object
     */
    public void buildMap() {
        for(int y = 0; y < board.getHeight(); y++) {
            ArrayList<BoardTile> mapRow = new ArrayList<>();
            for(int x = 0; x < board.getWidth(); x++) {
                Coordinate coordinate = new Coordinate(x, y);
                BoardTile tile = new BoardTile(coordinate);
                mapRow.add(switchTile(tile));
            }
            map.addRow(mapRow);
        }
    }

    /**
     * Tile Neighbors get generated after the initial generation.
     * Neighbors CANNOT overwrite non-empty tiles
     */
    public void generateNeighbours() {
        initiateProperties(board, you);

        snakeHeads.forEach(c -> assignArea(c, TileType.ENEMY_HEAD_NEIGHBOR));
        snakeBodies.forEach(c -> assignArea(c, TileType.ENEMY_BODY_NEIGHBOR));
        snakeTails.forEach(c -> assignArea(c, TileType.ENEMY_TAIL_NEIGHBOR));

        youBody.forEach(c -> assignArea(c, TileType.YOU_BODY_NEIGHBOR));
        assignArea(youTail, TileType.YOU_TAIL_NEIGHBOR);

        foods.forEach(c -> assignArea(c, TileType.FOOD_NEIGHBOR));
    }

    private void assignArea(Coordinate c, TileType type) {
        if (c.x < 0 || c.x >= board.getWidth()) return;
        if (c.y < 0 || c.y >= board.getHeight()) return;
        map.getAreaBoardTileList(c, 1)
                .forEach(t -> t.replaceType(type));
    }

    public static void logMap(BoardMap map) {
        StringBuilder sb = new StringBuilder();
        for (List<BoardTile> mapRow : map.get()) {
            sb.append("[ ");
            for (BoardTile tile : mapRow) {
                sb.append(tile.getTileType());
                sb.append(" ");
            }

            sb.append(" ]\n");
        }
        System.out.println(sb.toString());
    }

    private void flipAllLists() {
        int maxY = board.getHeight();

        this.snakeHeads.forEach(c -> c.flipY(maxY));
        this.snakeBodies.forEach(c -> c.flipY(maxY));
        this.snakeTails.forEach(c -> c.flipY(maxY));
        this.youHead.flipY(maxY);
        this.youBody.forEach(c -> c.flipY(maxY));
        this.youTail.flipY(maxY);
        this.foods.forEach(c -> c.flipY(maxY));
        this.hazards.forEach(c -> c.flipY(maxY));
    }
}
