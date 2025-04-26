import java.io.*;

public class StudentDataBinary {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {

        writeStudentData(101, "Alice", 3.8);
        writeStudentData(102, "Bob", 3.6);
        writeStudentData(103, "Charlie", 3.9);

        System.out.println("\nRetrieving Student Data:");
        readStudentData();
    }

    private static void writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Stored: " + rollNumber + ", " + name + ", " + gpa);
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Retrieved: " + rollNumber + ", " + name + ", " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }
}
