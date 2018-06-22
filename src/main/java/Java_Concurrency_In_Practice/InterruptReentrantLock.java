package main.java.Java_Concurrency_In_Practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangxiaolong on 2016/11/22.
 */
public class InterruptReentrantLock {
        static ReentrantLock lock1 = new ReentrantLock();
        static ReentrantLock lock2 = new ReentrantLock();

    public static class Task1 implements Runnable {
        @Override
        public void run() {
            try {
                lock1.lockInterruptibly();
                System.out.println("Task1 get lock1");
                Thread.sleep(2000);
                lock2.lockInterruptibly();

                System.out.println("Task1 get lock2");
                System.out.println("Task1");
            } catch (InterruptedException e) {
                if (lock2.isHeldByCurrentThread())
                    lock2.unlock();
                System.out.println("Task1 release lock2");
                if (lock1.isHeldByCurrentThread())
                    lock1.unlock();
                System.out.println("Task1 release lock1");
            }
        }
    }
    public static class Task2 implements Runnable{

        @Override
        public void run() {
            try {
                lock2.lockInterruptibly();
                System.out.println("Task2 get lock2");
                lock1.lockInterruptibly();
            System.out.println("Task2 get lock1");
            System.out.println("Task2");
            } catch (InterruptedException e) {
                if(lock1.isHeldByCurrentThread())
                    lock1.unlock();
                System.out.println("Task2 release lock1");
                if(lock2.isHeldByCurrentThread())
                    lock2.unlock();
                System.out.println("Task2 release lock2");
            }

        }
    }

    public static void main(String[] args){
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
