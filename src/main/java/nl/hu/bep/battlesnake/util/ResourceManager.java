package nl.hu.bep.battlesnake.util;

import nl.hu.bep.battlesnake.enums.TileType;
import nl.hu.bep.battlesnake.evaluation.MoveResult;
import nl.hu.bep.battlesnake.map.MapBuilder;
import nl.hu.bep.battlesnake.model.BoardMap;

public class ResourceManager {
    private final static boolean debug = false;
    public static void mapDebug(BoardMap map, MoveResult result) {
        if (!ResourceManager.debug) return;
        System.out.println("SUCCESSFULLY CREATED A PATH:");
        System.out.println("TOTAL COST:" + result.getPathCost());
        System.out.println("PATH:\n---");
        System.out.println(result.getPath().toString());
        System.out.println("---");
        System.out.println("PATH MAP\n---------------");
        result.getPath().forEach(p -> map.get().get(p.y).get(p.x).setTileType(TileType.NONE));
        MapBuilder.logMap(map);
        System.out.println("---\nEND OF LOG");
    }

    public static void dumpMap(BoardMap map) {
        MapBuilder.logMap(map);
    }
}
