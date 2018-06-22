package java_core.Mutithread;

import java.util.concurrent.CountDownLatch;

public class SynchronizedBlock {
    public static Integer i = 0;
    public static Object object = new Object();
    public static CountDownLatch countDownLatch = new CountDownLatch(1000);

    public static void main(String[] args) throws InterruptedException {
            ThreadForTest threadForTest = new ThreadForTest();
        for (int j = 0; j < 1000; j++) {
//            ThreadForTest threadForTest = new ThreadForTest(); you can not put in here
            Thread thread = new Thread(threadForTest);
            thread.start();
        }
        countDownLatch.await();
        System.out.println(i);
    }

    static class ThreadForTest implements Runnable {

        public void test1() {
            synchronized (object) {
                countDownLatch.countDown();
                i++;
            }
        }

        public void test2() {
            synchronized (SynchronizedBlock.class) {
                countDownLatch.countDown();
                i++;
            }
        }

        public synchronized void test3() {
            countDownLatch.countDown();
            i++;
        }

        @Override
        public void run() {
            test1();
        }
    }
}

