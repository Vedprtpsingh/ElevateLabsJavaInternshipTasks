import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private Map<Integer, Integer> issuedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    issuedBooks.put(bookId, user.getId());
                    System.out.println("Book issued to " + user.getName());
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isIssued()) {
                    book.setIssued(false);
                    issuedBooks.remove(bookId);
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();
                    library.issueBook(issueId, new User(userId, userName));
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}