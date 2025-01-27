package com.library.librarymanager;

import java.util.ArrayList;
import java.util.Scanner;

class Library {
    final ArrayList<Member> members = new ArrayList<Member>();

    public void addMember(String name, int age, char gender) {
        Member member = new Member(name, age, gender);
        members.add(member);
        System.out.println("member " + name + " with member Id " + member.getMemberId() + " added to library");
    }

    public void displayMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                member.displayInfo();
                return;
            }
        }
        System.out.println("member " + memberId + " not found" + "\nEnter a valid member ID please!");
    }

    public void editMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                member.displayInfo();
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Which info do you want to edit?\n1.name\n2.age\n3.gender\n");
                    System.out.println("if you don't want to change anything, please enter >>> 5 <<<");
                    System.out.print("Enter your command here: ");
                    int choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.print("Enter new name: ");
                            String name = scanner.next();
                            member.setName(name);
                            System.out.println("name is updated to " + name + "\n");
                            break;
                        case 2:
                            System.out.print("Enter new age: ");
                            int age = scanner.nextInt();
                            member.setAge(age);
                            System.out.println("age is updated to " + age + "\n");
                            break;
                        case 3:
                            System.out.print("Enter new gender: ");
                            char gender = scanner.next().charAt(0);
                            member.setGender(gender);
                            System.out.println("gender is updated to " + gender + "\n");
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("Invalid choice\nplease enter a valid number between\n" +
                                    "\t1\t2\t3\t5");
                    }
                }
            }
        }
        System.out.println("member " + memberId + " not found" + "\nEnter a valid member ID please!");
    }

    public void deleteMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                members.remove(member);
                System.out.println("member " + memberId + " removed from the library!!!");
                return;
            }
        }
        System.out.println("member " + memberId + " not found" + "\nEnter a valid member ID please!");
    }
}
