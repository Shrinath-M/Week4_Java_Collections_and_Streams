import java.io.*;

public class FileMerger {
    public static void mergeFiles(String file1, String file2, String outputFile) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;


            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files merged successfully into " + outputFile);

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String file1 = "C:\\Users\\shrin\\OneDrive\\Documents\\File.txt";
        String file2 = "C:\\Users\\shrin\\OneDrive\\Documents\\Destination.txt";
        String outputFile = "C:\\Users\\shrin\\OneDrive\\Documents\\Third.txt";

        mergeFiles(file1, file2, outputFile);
    }
}
