package Java_Concurrency_In_Practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codebug on 16-11-20.
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " : Thread ID :" + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args){
        MyTask task = new MyTask();
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
    }
}
