/**
 * JavaThreads2
 * By implementing Runnable interface.
 */
public class JavaThreads2 implements Runnable{

    public void run(){
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        JavaThreads2 threads2 = new JavaThreads2();

        Thread thread = new Thread(threads2);

        thread.start();
    }
}