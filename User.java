import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Account account;
    private List<Book> borrowedBooks;

    public User(String name, Account account) {
        this.name = name;
        this.account = account;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
