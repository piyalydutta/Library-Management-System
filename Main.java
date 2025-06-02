import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize library
        List<Book> bookList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        Library library = new Library(bookList, userList);

        // Add books via Librarian
        Librarian librarian = new Librarian("Libby", new Account("lib001", "pass123"));
        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);

        Scanner scanner = new Scanner(System.in);

        // Register a user
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Create user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Create password: ");
        String password = scanner.nextLine();

        User user = new User(name, new Account(userId, password));
        library.registerUser(user);
        System.out.println("User registered successfully.\n");

        // Menu loop
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.println("Available books:");
                    for (Book b : library.getBooks()) {
                        if (b.isAvailable()) {
                            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Enter title of book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowBook = null;
                    for (Book b : library.getBooks()) {
                        if (b.getTitle().equalsIgnoreCase(borrowTitle)) {
                            borrowBook = b;
                            break;
                        }
                    }
                    if (borrowBook != null) {
                        user.borrowBook(borrowBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter title of book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = null;
                    for (Book b : library.getBooks()) {
                        if (b.getTitle().equalsIgnoreCase(returnTitle)) {
                            returnBook = b;
                            break;
                        }
                    }
                    if (returnBook != null) {
                        user.returnBook(returnBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                }

                case 0 -> {
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }
}


