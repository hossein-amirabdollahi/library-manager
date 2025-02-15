package com.library.librarymanager;

import java.util.Scanner;

public class Person implements Entity {

    protected String name;
    protected String email;
    protected String phone;

    @Override
    public Integer getID() {
        return 0;
    }

    @Override
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

    @Override
    public void showOnConsole() {
        System.out.printf("Name: %s | Email: %s | Phone: %s%n",
                name, email, phone);
    }

}
