package com.library.librarymanager;

import java.util.Scanner;

public class LibraryManaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library1 = new Library();
        System.out.println("Welcome to the com.library.librarymanager.Library Manager");
        while (true) {
            System.out.println("\nPlease enter your command from further menu");
            System.out.println("\t1. Add a new member");
            System.out.println("\t2. Display member");
            System.out.println("\t3. Edit member");
            System.out.println("\t4. Delete member");
            System.out.println("\t5. Exit");
            System.out.print("Enter your command here: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Please enter the name of the member: ");
                    String name = sc.next();
                    System.out.print("Please enter the age of the member: ");
                    int age = sc.nextInt();
                    System.out.print("Please enter the gender of the member(F as female and M as male): ");
                    char gender = sc.next().charAt(0);
                    library1.addMember(name, age, Character.toUpperCase(gender));
                    break;

                case 2:
                    System.out.print("Please enter the ID of the member: ");
                    int id = sc.nextInt();
                    library1.displayMember(id);
                    break;

                case 3:
                    System.out.print("Please enter the ID of the member: ");
                    id = sc.nextInt();
                    library1.editMember(id);
                    break;

                case 4:
                    System.out.print("Please enter the ID of the member: ");
                    id = sc.nextInt();
                    library1.deleteMember(id);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Please enter a valid number between 1 and 5");
            }

        }
    }
}

