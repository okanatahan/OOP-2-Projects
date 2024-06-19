package myPackage;

public class Student {
    private static long studentID;
    private static String name;
    private static String surname;

    public static void definer(long id, String name, String surname){
        studentID = id;
        Student.name = name;
        Student.surname = surname;
    }

    public static void printer(){
        System.out.println("Student ID: " + studentID + "\nName: " + name + "\nSurname: " + surname);
    }
}