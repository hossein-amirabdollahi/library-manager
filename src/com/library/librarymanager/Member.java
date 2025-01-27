package com.library.librarymanager;

class Member {
    private static int idCounter = 1;
    private final int memberId;
    private String name;
    private int age;
    private char gender;

    public Member(String name, int age, char gender) {
        this.memberId = idCounter;
        idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Member Name: " + name);
        System.out.println("Member Age: " + age);
        if (gender == 'M')
            System.out.println("Member Gender: Male");
        else if (gender == 'F')
            System.out.println("Member Gender: Female");
    }
}
