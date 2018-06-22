package Java_Concurrency_In_Practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by codebug on 16-11-21.
 */
public class TryLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            if(lock.tryLock()){
                System.out.println("Locked");
                System.out.println("Sleeping");
                Thread.sleep(6000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
                System.out.println("unlocked");
            }
        }
    }

    public static void main(String[] args){
        TryLock tryLock = new TryLock();
        Thread t1 = new Thread(tryLock);
        Thread t2 = new Thread(tryLock);
        t1.start();
        t2.start();
    }
}
