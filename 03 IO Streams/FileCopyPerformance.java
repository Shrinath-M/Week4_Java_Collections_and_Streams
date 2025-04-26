import java.io.*;

public class FileCopyPerformance {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String bufferedDestFile = "buffered_copy.txt";
        String unbufferedDestFile = "unbuffered_copy.txt";

        System.out.println("Copying using Buffered Streams...");
        long bufferedTime = copyFileBuffered(sourceFile, bufferedDestFile);
        System.out.println("Buffered Streams Time: " + bufferedTime + " ns");

        System.out.println("\nCopying using Unbuffered Streams...");
        long unbufferedTime = copyFileUnbuffered(sourceFile, unbufferedDestFile);
        System.out.println("Unbuffered Streams Time: " + unbufferedTime + " ns");

        System.out.println("\nPerformance Comparison:");
        System.out.println("Buffered streams were " + (double) unbufferedTime / bufferedTime + " times faster.");
    }

    private static long copyFileBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyFileUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
