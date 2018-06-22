package Java_Concurrency_In_Practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by codebug on 16-11-21.
 */
public class ReenterLockDemo implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            lock.lock();
            lock.lock();
            try {
                System.out.println(i++);
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReenterLockDemo reenterLockDemo = new ReenterLockDemo();
        Thread t1 = new Thread(reenterLockDemo);
        Thread t2 = new Thread(reenterLockDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
