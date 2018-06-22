package main.java.Java_Concurrency_In_Practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangxiaolong on 2016/11/22.
 */
public class YeildDemo {
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static class Task1 implements Runnable{
        @Override
        public void run() {
            reentrantLock.lock();

            Thread.yield();//yeild do not release the lock
            System.out.println("Task1 : " + "Thread id"  +Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }
    }
    public static class Task2 implements Runnable{
        @Override
        public void run() {
            reentrantLock.lock();
            System.out.println("Task2 : " +"Thread id"  + Thread.currentThread().getId());
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args){
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(t1);
        es.submit(t2);
        es.shutdown();
    }
}
