package Java_Concurrency_In_Practice;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codebug on 16-11-20.
 */
public class CountDownLatchDemo implements Runnable{
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();


    @Override
    public void run() {

        System.out.println("check complete");
        end.countDown();
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(demo);
        }
        end.await();
        System.out.println("Fire!");
        exec.shutdown();
    }
}
