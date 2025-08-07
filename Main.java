import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        library.addBook(new Book(bookId, title, author));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter User ID: ");
                        int userId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter User Name: ");
                        String name = sc.nextLine();

                        library.registerUser(new User(userId, name));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Book ID to issue: ");
                        int bookId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter User ID: ");
                        int userId = Integer.parseInt(sc.nextLine());

                        library.issueBook(bookId, userId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Book ID to return: ");
                        int bookId = Integer.parseInt(sc.nextLine());
                        library.returnBook(bookId);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;

                case 5:
                    library.viewAllBooks();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Choose between 1–6.");
            }
        }
    }
}
