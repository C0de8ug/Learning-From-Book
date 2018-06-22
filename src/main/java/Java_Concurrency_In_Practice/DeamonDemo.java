package Java_Concurrency_in_Practice;

/**
 * Created by huangxiaolong on 2016/11/18.
 */
public class DeamonDemo {
    public static class DaemonT extends Thread{
        public void run(){
            while(true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException{
            Thread t = new DaemonT();
            t.setDaemon(false);
            t.start();

            Thread.sleep(2000);
        }
    }
}
