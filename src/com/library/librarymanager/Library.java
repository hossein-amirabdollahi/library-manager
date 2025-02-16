package com.library.librarymanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {

    private final Map<Integer, Book> books = new HashMap<>();
    private final Map<Integer, Member> members = new HashMap<>();

    private final Map<Integer, Integer> borrowedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getID(), book);
    }

    public void addMember(Member member) {
        members.put(member.getID(), member);
    }

    public void borrowBook(Integer memberID, Integer bookID) {
        if (!members.containsKey(memberID)) {
            System.out.println("Member not found!");
            return;
        }

        Book book = books.get(bookID);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.getStatus() == BookStatus.BORROWED) {
            System.out.println("Book already borrowed!");
            return;
        }

        book.setStatus(BookStatus.BORROWED);
        borrowedBooks.put(bookID, memberID);
        System.out.println("Book borrowed successfully!");
    }

    public void returnBook(Integer bookID) {
        if (!borrowedBooks.containsKey(bookID)) {
            System.out.println("Book wasn't borrowed!");
            return;
        }

        Book book = books.get(bookID);
        book.setStatus(BookStatus.AVAILABLE);
        borrowedBooks.remove(bookID);
        System.out.println("Book returned successfully!");
    }

    public List<Book> findBooks(Predicate<Book> predicate) {
        return books.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void deleteBook(Integer bookID) {
        if (!books.containsKey(bookID)) {
            System.out.println("Book not found!");
            return;
        }
        books.remove(bookID);
    }

    public void deleteMember(Integer memberID) {
        if (!members.containsKey(memberID)) {
            System.out.println("Member not found!");
            return;
        }
        members.remove(memberID);
    }


}
