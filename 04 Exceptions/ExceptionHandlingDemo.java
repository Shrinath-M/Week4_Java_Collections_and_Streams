import java.io.*;
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            processData(10, 0, "data.txt"); // Will trigger ArithmeticException
        } catch (IOException e) {
            System.err.println("Checked Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Unchecked Exception: " + e.getMessage());
        }
    }
    public static void processData(int num1, int num2, String filePath) throws IOException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        int result = num1 / num2;
        System.out.println("Result: " + result);
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File '" + filePath + "' not found.");
        }
    }
}
