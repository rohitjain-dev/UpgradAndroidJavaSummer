/**
 * JavaThreads
 * By extending Thread class
 */
public class JavaThreads extends Thread {

    public void run()
    {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        JavaThreads t1 = new JavaThreads();
        t1.start();
    }
}