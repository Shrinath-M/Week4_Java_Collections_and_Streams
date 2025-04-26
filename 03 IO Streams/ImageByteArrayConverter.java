import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String outputImage = "output.jpg";

        try {
            byte[] imageBytes = convertImageToByteArray(sourceImage);
            System.out.println("Image successfully converted to byte array.");

            writeByteArrayToImage(imageBytes, outputImage);
            System.out.println("Byte array successfully written to new image file.");


            if (verifyImages(sourceImage, outputImage)) {
                System.out.println("Verification successful: The images are identical.");
            } else {
                System.out.println("Verification failed: The images are different.");
            }

        } catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(imagePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static boolean verifyImages(String originalPath, String outputPath) throws IOException {
        byte[] originalBytes = Files.readAllBytes(Path.of(originalPath));
        byte[] outputBytes = Files.readAllBytes(Path.of(outputPath));
        return Arrays.equals(originalBytes, outputBytes);
    }
}
