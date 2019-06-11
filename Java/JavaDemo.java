
/**
 * Student
 */
class Student {
    String name;
    int rollno;
    String courses;
    
    //constructor
    Student(){
    }
    Student(String name,int rollno,String courses){
       this.name = name;
       this.rollno = rollno;
       this.courses = courses;
    }

    Student(String name){
     this.name = name;
    }
    //Getter Methods

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the rollno
     */
    public int getRollno() {
        return rollno;
    }

    /**
     * @return the courses
     */
    public String getCourses() {
        return courses;
    }
}
/**
 * JavaDemo
 */
public class JavaDemo {

    public static void main(String[] args) {
        //create an object for class
        Student stud1 = new Student("rohit");
        Student stud2 = new Student("Anurag",1,"Android With Upgrad");
        System.out.println(stud1.getName());
        System.out.println(stud2.getName());
        System.out.println(stud2.getRollno());
        System.out.println(stud2.getCourses());
    }
}