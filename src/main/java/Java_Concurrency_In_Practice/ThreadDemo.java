package Java_Concurrency_In_Practice;

/**
 * Created by codebug on 16-11-21.
 */
public class ThreadDemo {
    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("begin");
        }
    }

    public static void main(String args[]){
        Task task = new Task();
        Thread t = new Thread(task);

        t.start();
        System.out.println(t.getState());
        t.start();
    }

}
