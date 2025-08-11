
import java.io.*;
import java.util.Scanner;
public class NotesManager {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- Text Notes Manager ---");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void writeNote(Scanner scanner) {
        System.out.println("Enter your note:");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    private static void readNotes() {
        System.out.println("\n--- Saved Notes ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                isEmpty = false;
            }
            if (isEmpty) {
                System.out.println("No notes found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes file found. Please write a note first.");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}