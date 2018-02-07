package assignment.pkg1;

/*
 * Laurens Kubat s4626249
 * Reinier Sanders s4335422
 */

public class Student{
    private String name;
    private int studentNumber;
    
    public Student(String name, int studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
    }
    
    public void changeStudentName(String newName){
        this.name = newName;
    }
    
    @Override
    public String toString(){
        return this.name + "\t" + "s" + this.studentNumber;
    }
    
    public boolean findStudent(int searchNumber){
        return searchNumber == this.studentNumber;
    }
}
