import okanATAHAN.Student;
import okanATAHAN.Faculty;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the ID of the student: ");
        long id = input.nextLong();

        System.out.println("Please enter the name of the student: ");
        input.nextLine();
        String name = input.nextLine();

        System.out.println("Please enter the surname of the student: ");
        String surname = input.nextLine();

        Student.definer(id, name, surname);
        Student.printer();

        System.out.println("Please enter student's faculty name: ");
        String facultyName = input.nextLine();

        Faculty.whichFaculty(facultyName);
    }
}