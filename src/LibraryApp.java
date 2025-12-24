import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addNewBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBookById();
                case 7 -> {
                    System.out.println("Exiting Library App. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nWelcome to Library App!");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        books.forEach(System.out::println);
    }

    private void addNewBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        int year = readInt("Enter year: ");

        try {
            Book book = new Book(title, author, year);
            books.add(book);
            System.out.println("Book added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchByTitle() {
        System.out.print("Enter part of the title: ");
        String part = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(part)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found.");
        }
    }

    private void borrowBook() {
        int id = readInt("Enter book id: ");

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            book.markAsBorrowed();
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    private void returnBook() {
        int id = readInt("Enter book id: ");

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            book.markAsReturned();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is already available.");
        }
    }

    private void deleteBookById() {
        int id = readInt("Enter book id: ");

        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    private int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
