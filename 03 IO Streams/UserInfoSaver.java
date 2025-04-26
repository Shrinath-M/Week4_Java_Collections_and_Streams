import java.io.*;

public class UserInfoSaver {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String favoriteLanguage = reader.readLine();

            saveToFile(name, age, favoriteLanguage);
            System.out.println("Information saved successfully!");
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    private static void saveToFile(String name, String age, String language) {
        try (FileWriter writer = new FileWriter("user_info.txt", true)) {
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("----------------------------\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
