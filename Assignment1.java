package assignment.pkg1;

import java.util.Scanner;

/*
 * Laurens Kubat s4626249
 * Reinier Sanders s4335422
 */

public class Assignment1 {

    public static void main(String[] args) {
        System.out.println("Enter the amount of students: ");
        Scanner scan = new Scanner (System.in);
        int groupSize = scan.nextInt();
        Student[] studentArray = new Student[groupSize];
        System.out.println("\n");
        for (int i = 0; i < groupSize; i++){
            System.out.println("Enter a student name and press return."
                    + " Then enter the student number (without s) and press"
                    + " return:");
            String studentName = readString();
            int studentNumber = scan.nextInt();
            Student newStudent = new Student(studentName, studentNumber);
            studentArray[i] = newStudent;
        }
        System.out.println("\n");
        System.out.println("The group now contains: \n");
        for(int i = 0; i < groupSize; i++){
            System.out.println(studentArray[i].toString());
        }
        System.out.println("\n");
        while(true){
            System.out.println("Enter a studentnumber (without s) and press"
                    + " return:");
            int studentNumber = scan.nextInt();
            if(studentNumber < 0){
                return;
            }
            for(int i = 0; i < groupSize; i++){
                if(studentArray[i].findStudent(studentNumber)){
                    System.out.println("Enter new student name and press"
                            + " return. A negative student number will quit the"
                            + " program.");
                    String studentName = readString();
                    studentArray[i].changeStudentName(studentName);
                }
                else System.out.println("Student number not found.");
            }
            System.out.println("\n");
            System.out.println("The group now contains: \n");
            for(int i = 0; i < groupSize; i++){
                System.out.println(studentArray[i].toString());
            }
        }
    }
    
    private static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}