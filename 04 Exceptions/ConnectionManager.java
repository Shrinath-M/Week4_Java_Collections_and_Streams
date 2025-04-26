import java.io.Closeable;
import java.io.IOException;

class Connection implements Closeable {
    public void open() {
        System.out.println("Connection opened.");
    }
    public void process() throws IOException {
        throw new IOException("Error processing connection.");
    }
    @Override
    public void close() throws IOException {
        System.out.println("Connection closed.");
    }
}
public class ConnectionManager {
    public static void main(String[] args) {
        try (Connection conn = new Connection()) {
            conn.open();
            conn.process();
        } catch (IOException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }
}
