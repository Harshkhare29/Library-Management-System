import java.util.*;

public class User {
    private String userID;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isIssued()) {
            System.out.println("Book is already issued: " + book.getTitle());
        } else {
            book.issueBook();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed the book: " + book.getTitle());
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println(name + " returned the book: " + book.getTitle());
        } else {
            System.out.println(name + " has not borrowed the book: " + book.getTitle());
        }
    }
}
