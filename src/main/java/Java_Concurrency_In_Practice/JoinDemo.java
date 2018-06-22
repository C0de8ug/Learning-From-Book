package Java_Concurrency_In_Practice;

/**
 * Created by codebug on 16-11-18.
 */
public class JoinDemo implements Runnable{
    static JoinDemo instance = new JoinDemo();

    @Override
    public void run() {
        for (int j = 0 ; j < 10; j++){
            System.out.println(j);
        }
    }

    public static void main(String[] args){
        System.out.println("Main Thread Start");
        Thread t1 = new Thread(instance);
        t1.start();
        System.out.println("t1 begin");
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finished");

    }
}
