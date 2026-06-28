package nl.hu.bep.battlesnake.evaluation;

import nl.hu.bep.battlesnake.enums.Playstyle;
import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.model.BoardTile;

public class ScoreAssigner {
    Playstyle activePlaystyle;

    /**
     * @param activePlaystyle
     * @see nl.hu.bep.battlesnake.enums.TileType
     */
    public ScoreAssigner(Playstyle activePlaystyle) {
        this.activePlaystyle = activePlaystyle;
    }

    public calculateCost(BoardTile tile) {
        TileType tileType = tile.getTileType();
        tile.setCost(calculateNeutral(tileType));
//        tile.setCost(switch (activePlaystyle) {
//            case DEFENSIVE -> calculateDefensive(tileType);
//            case NEUTRAL -> calculateNeutral(tileType);
//            case OFFENSIVE -> calculateOffensive(tileType);
//        });
    }

    private int calculateNeutral(TileType type) {
        // Baseline point-calculation
        return TileType.getCost(type);
    }

//    private int calculateDefensive(TileType type) {
//        return switch (type) {
//            case NONE -> 0;
//            case EMPTY -> 5;
//            case WALL -> 100;
//            case FOOD -> -10;
//            case HAZARD -> 15;
//            case ENEMY_HEAD, ENEMY_BODY -> 100;
//            case ENEMY_TAIL -> 10;
//            case FRIENDLY_HEAD, FRIENDLY_BODY -> 15;//hazard score
//            case FRIENDLY_TAIL -> 15;//hazard score
//            case YOU_HEAD, YOU_BODY -> 100;
//            case YOU_TAIL -> 20;
//        };
//    }
//
//    private int calculateOffensive(TileType type) {
//        // Baseline point-calculation
//        return switch (type) {
//            case NONE -> 0;
//            case EMPTY -> 5;
//            case WALL -> 100;
//            case FOOD -> -10;
//            case HAZARD -> 15;
//            case ENEMY_HEAD, ENEMY_BODY -> 100;
//            case ENEMY_TAIL -> 10;
//            case FRIENDLY_HEAD, FRIENDLY_BODY -> 15;//hazard score
//            case FRIENDLY_TAIL -> 15;//hazard score
//            case YOU_HEAD, YOU_BODY -> 100;
//            case YOU_TAIL -> 20;
//        };
//    }
}
