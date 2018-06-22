package Java_Concurrency_In_Practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by codebug on 16-11-21.
 */
public class ReentrantLockCondition implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try{
            lock.lock();
            condition.await();//this will release lock
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockCondition rl = new ReentrantLockCondition();
        Thread t1 = new Thread(rl);
        t1.start();
        Thread.sleep(3000);
        lock.lock();
        condition.signal();
    }
}
