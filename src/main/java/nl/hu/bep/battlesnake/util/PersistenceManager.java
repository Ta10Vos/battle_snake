package nl.hu.bep.battlesnake.util;

import nl.hu.bep.battlesnake.model.Customization;

public class PersistenceManager
{
    public final static String filesDirectory = System.getProperty("user.dir") + "../files";
    public final static String snakesDirectory = filesDirectory + "/snakes";
    static boolean saveCustomization(String snakeId, Customization customization) {
        String snakeJson = "";
        return FileManager.tryWriteToFile(filesDirectory, snakeId + ".txt", snakeJson);
    }

    /**
     * Try to find a customization based on the snakeId (fileName)
     * @param snakeId id of the snake aka the name used to save/search it.
     * @return null | String
     */
    static Customization getCustomization(String snakeId) {
        String customizationJson = FileManager.tryReadFile(filesDirectory, snakeId + ".txt");
        Customization customization = new Customization();
        return customization;
    }
}
