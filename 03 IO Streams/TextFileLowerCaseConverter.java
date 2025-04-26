import java.io.*;

public class TextFileLowerCaseConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File conversion successful! Check '" + outputFile + "'.");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
