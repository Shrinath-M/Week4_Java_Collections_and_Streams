import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {

    public static void writeToFile(String filename, String content) throws IOException {
        Path path = Paths.get(filename);
        Files.writeString(path, content);
    }

    public static String readFromFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readString(path);
    }
}
