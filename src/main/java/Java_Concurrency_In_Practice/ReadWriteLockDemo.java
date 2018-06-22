package Java_Concurrency_In_Practice;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by codebug on 16-11-19.
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public void handleRead(Lock lock) throws InterruptedException {
        try{
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read "  + value);
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock ,int index) throws InterruptedException {
        try{
            lock.lock();
            Thread.sleep(1000);
            value = index;
            System.out.println("write " + value);
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
 //                  demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    int value = new Random().nextInt();
                    demo.handleWrite(writeLock,value);
//                    demo.handleWrite(lock,value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        long startTime = System.currentTimeMillis();

        System.out.println();
        for (int i = 0; i < 18;i++){
            new Thread(readRunnable).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
        long endTime = System.currentTimeMillis();


    }
}
