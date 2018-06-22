package Java_Concurrency_In_Practice;

import java.util.concurrent.*;

/**
 * Created by codebug on 16-11-20.
 */
public class RejectedExecutionHandler {
    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread Id " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new java.util.concurrent.RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                System.out.println(runnable.toString() + "is discard");
            }
        });
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            Thread.sleep(10);
        }
    }
}
