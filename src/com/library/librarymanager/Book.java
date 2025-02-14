package com.library.librarymanager;

import java.util.Scanner;

public class Book implements Entity {

    private Integer id;
    private String title;
    private String author;
    private BookStatus status = BookStatus.AVAILABLE;

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public void readFromConsole() throws BadEntityException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Book ID: ");
            id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Title: ");
            title = scanner.nextLine();
            System.out.print("Enter Author: ");
            author = scanner.nextLine();

            if (title.isEmpty() || author.isEmpty()) {
                throw new BadEntityException("Title/Author cannot be empty!");
            }
        } catch (NumberFormatException e) {
            throw new BadEntityException("Invalid ID format");
        }
    }

    @Override
    public void showOnConsole() {
        System.out.printf("[ID: %d] %s by %s (%s)%n",
                id, title, author, status);
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
