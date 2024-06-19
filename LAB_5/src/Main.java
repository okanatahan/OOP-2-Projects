import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("LAB_5\\txtFolder\\txtFile.txt");
        try {
            if (myFile.createNewFile()){
                System.out.println("\nFile is Created.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the data that you want to write into the text file: ");

        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("txtFile.txt"));
            for (int i = 0; i < 5; i++){
                String data = input.nextLine();
                myWriter.write(data);
            }
            myWriter.close();
            System.out.println("\nSuccessfully written.\n");
        } catch(IOException e) {
            System.out.println("\nAn error has occurred\n");
            e.printStackTrace();
        }

        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String dataToRead = myReader.nextLine();
                System.out.println(dataToRead);
            }
            myReader.close();
        } catch(FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (myFile.exists()) {
            System.out.println("The name of the file is: " + myFile.getName());
            System.out.println("The absolute path of the file is: " + myFile.getAbsolutePath());
            System.out.println("Is file writeable: " + myFile.canWrite());
            System.out.println("Is file readable: " + myFile.canRead());
            System.out.println("The size of the file in bytes is: " + myFile.length());
        } else {
            System.out.println("\nThe file does not exists.");
        }

        File myFolder = new File("LAB_5\\txtFolder");
        String[] fileList = myFolder.list();
        System.out.println("\nAll of the files in the folder before deletion: ");
        if (fileList.length == 0){
            System.out.println("No file is found in the folder.");
        } else {
            for (String str : fileList){
                System.out.println("\t" + str);
            }
        }

        System.out.println();

        if (myFile.delete()) {
            System.out.println(myFile.getName() + " file is deleted successfully.");
        } else {
            System.out.println("Unexpected error found in deletion of the file.");
        }

        System.out.println();

        String[] fileListAfter = myFolder.list();
        System.out.println("All of the files in the folder after deletion: ");
        if (fileListAfter.length == 0){
            System.out.println("\tNo file is found in the folder.");
        } else {
            for (String str : fileList){
                System.out.println("\t" + str);
                }
        }
    }
}