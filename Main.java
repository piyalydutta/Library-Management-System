import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create sample books
        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");

        // Create empty library
        List<Book> bookList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        Library library = new Library(bookList, userList);

        // Librarian adds books
        Librarian librarian = new Librarian("Libby", new Account("lib001", "pass123"));
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);

        // Create user and register
        User user = new User("Alice", new Account("alice01", "mypassword"));
        library.registerUser(user);

        // User borrows and returns book
        user.borrowBook(book1);
        user.returnBook(book1);
        user.borrowBook(book2);
    }
}

