import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book("B001", "Java Programming", "James Gosling"));
        library.addBook(new Book("B002", "Data Structures", "Mark Allen Weiss"));
        library.addBook(new Book("B003", "Algorithms", "Robert Sedgewick"));

        // Add some users
        User user1 = new User("U001", "Alice");
        User user2 = new User("U002", "Bob");

        library.addUser(user1);
        library.addUser(user2);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter User ID to issue book: ");
                    String issueUserID = scanner.nextLine();
                    System.out.print("Enter Book ID to issue: ");
                    String issueBookID = scanner.nextLine();
                    library.issueBook(issueUserID, issueBookID);
                    break;
                case 3:
                    System.out.print("Enter User ID to return book: ");
                    String returnUserID = scanner.nextLine();
                    System.out.print("Enter Book ID to return: ");
                    String returnBookID = scanner.nextLine();
                    library.returnBook(returnUserID, returnBookID);
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
