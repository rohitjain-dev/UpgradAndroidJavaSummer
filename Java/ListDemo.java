import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ListDemo
 */
public class ListDemo {
   
    //declare list
    
    public static void main(String[] args) {
        //declare
        List<String> students = new ArrayList<String>();

        //adding
        students.add("Ashish");
        students.add("Ravi");
        students.add("Rohit");
        students.add("jon");
        students.add("tyrion");
        
        //iterator

        Iterator listitIterator = students.iterator();
        while(listitIterator.hasNext()){
            System.out.println(listitIterator.next());
        }
    }
}