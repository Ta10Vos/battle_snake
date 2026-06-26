package nl.hu.bep.battlesnake.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class FileManager {
    public static boolean tryWriteToFile(String fileDirectory, String fileName, String stringToSave) {
        File file = new File(fileDirectory + "/" + fileName + ".json");

        Path path = file.toPath();
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {
            bw.write(stringToSave);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Returns null if unable to find or read the specified file, otherwise returns
     * the JSON String of this file.
     * @param fileDirectory the directory where your file is in
     * @param fileName the name of your file
     * @return null | String
     */
    public static String tryReadFile(String fileDirectory, String fileName) {
        Path path = Paths.get(fileDirectory + "/" + fileName);
        File file = new File(path.toAbsolutePath().toString());

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }

        return sb.toString();
    }
}
