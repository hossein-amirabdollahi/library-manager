package com.library.librarymanager;

import java.util.Scanner;

public class Person {

    protected String name;
    protected String email;
    protected String phone;

    public void readFromConsole() throws BadEntityException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Email: ");
        email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        phone = scanner.nextLine();

        if (name.isEmpty()) {
            throw new BadEntityException("Name cannot be empty!");
        }

    }

    public void showOnConsole() {
        System.out.printf("Name: %s | Email: %s | Phone: %s%n",
                name, email, phone);
    }

}
