import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered successfully.");
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (book.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            book.issueBook();
            System.out.println("Book issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or not issued.");
        }
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- All Books ---");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getBookId() == id) return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }
}
