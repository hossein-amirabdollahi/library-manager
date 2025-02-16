package com.library.librarymanager;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class LibraryApp {

    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. Delete Book");
            System.out.println("7. Delete Member");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBooks();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    deleteMember();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addBook() {
        try {
            Book book = new Book();
            book.readFromConsole();
            library.addBook(book);
            System.out.println("Book added successfully!");
        } catch (BadEntityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addMember() {
        try {
            Member member = new Member();
            member.readFromConsole();
            library.addMember(member);
            System.out.println("Member added successfully!");
        } catch (BadEntityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void borrowBook() {
        System.out.print("Enter Member ID: ");
        int memberID = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bookID = scanner.nextInt();
        library.borrowBook(memberID, bookID);
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookID = scanner.nextInt();
        library.returnBook(bookID);
    }

    private static void searchBooks() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        Predicate<Book> searchPredicate = book ->
                book.getID().toString().contains(searchTerm) ||
                        book.getTitle().toLowerCase().contains(searchTerm) ||
                        book.getAuthor().toLowerCase().contains(searchTerm);

        List<Book> results = library.findBooks(searchPredicate);
        System.out.println("\nSearch Results:");
        results.forEach(Book::showOnConsole);
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int bookID = scanner.nextInt();
        library.deleteBook(bookID);
        System.out.println("Book deleted successfully!");

    }

    private static void deleteMember() {
        System.out.print("Enter Member ID to delete: ");
        int memberID = scanner.nextInt();
        library.deleteMember(memberID);
        System.out.println("Member deleted successfully!");
    }

}
