package okanATAHAN;

public class Faculty {
    public static void whichFaculty(String name){
        if (name.equals("CEN")){
            System.out.println("You are directed to the Department of Computer Engineering");
        } else if (name.equals("SEN")){
            System.out.println("You are directed to the Department of Software Engineering");
        } else {
            System.out.println("You are directed to the Faculty Secretariat");
        }
    }
}
