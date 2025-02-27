package com.library.librarymanager;

import java.util.Scanner;

public class Member extends Person {

    private Integer memberID;

    public Integer getID() {
        return memberID;
    }

    public void readFromConsole() throws BadEntityException {
        super.readFromConsole();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Member ID: ");
            memberID = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new BadEntityException("Invalid Member ID format");
        }
    }

    @Override
    public void showOnConsole() {
        System.out.printf("Member ID: %d | ", memberID);
        super.showOnConsole();
    }

}
