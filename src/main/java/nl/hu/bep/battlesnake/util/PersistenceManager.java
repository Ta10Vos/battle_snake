package nl.hu.bep.battlesnake.util;

import nl.hu.bep.battlesnake.model.Customization;

public class PersistenceManager
{
    private static Customization customization;
    public final static String filesDirectory = System.getProperty("user.dir") + "../files";
    public final static String snakesDirectory = filesDirectory + "/snakes";

    /**
     * Save customization
     * @param customization the updated customization to save
     * @return boolean indicating whether the customization has been successfully saved or not
     */
    public static boolean saveCustomization(Customization customization) {
        PersistenceManager.customization = customization;
        return true;
//        // Persistence below
//        String snakeJson = "";
//        return FileManager.tryWriteToFile(filesDirectory, snakeId + ".txt", snakeJson);
    }

    /**
     * Get the customization
     * @return Customization
     */
    public static Customization getCustomization() {
        return PersistenceManager.customization;
//        String customizationJson = FileManager.tryReadFile(filesDirectory, snakeId + ".txt");
//        Customization customization = new Customization();
//        return customization;
    }
}
