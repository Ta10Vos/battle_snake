package nl.hu.bep.battlesnake.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public abstract class FileManager {
    public static boolean tryWriteJson(String fileDirectory, String fileName, String jsonToSave) {
        File file = new File(fileDirectory + "/" + fileName + ".json");

        Path path = file.toPath();
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
            bw.write(jsonToSave);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean tryGetJson(String fileDirectory, String fileName) {

    }
}
