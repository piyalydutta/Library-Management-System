public class Librarian extends User {

    public Librarian(String name, Account account) {
        super(name, account);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Library library, Book book) {
        if (library.getBooks().remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }
}
