import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<User> users;

    public Library(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }
}
