import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Add a new user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    // Issue a book to a user
    public void issueBook(String userID, String bookID) {
        User user = findUser(userID);
        Book book = findBook(bookID);

        if (user != null && book != null) {
            user.borrowBook(book);
        } else {
            System.out.println("User or Book not found.");
        }
    }

    // Return a book from a user
    public void returnBook(String userID, String bookID) {
        User user = findUser(userID);
        Book book = findBook(bookID);

        if (user != null && book != null) {
            user.returnBook(book);
        } else {
            System.out.println("User or Book not found.");
        }
    }

    // Display all books in the library
    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println("ID: " + book.getBookID() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Issued: " + (book.isIssued() ? "Yes" : "No"));
        }
    }

    // Find a book by its ID
    private Book findBook(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

    // Find a user by their ID
    private User findUser(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
}
