import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library1 = new Library();
        System.out.println("Welcome to the Library Manager");
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
                    library1.addMember(name, age, gender);
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
                while (true){
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