package Java_Concurrency_In_Practice;

/**
 * Created by huangxiaolong on 2016/11/18.
 */
public class PriorityDemo {
    public static class HighPriority extends Thread{
        static int count = 0;
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count > 10000000){
                        System.out.println("HighPriority is compele");
                        break;
                    }
                }
            }
        }
    }
    public static class LowPriority extends Thread{
        static int count = 0;
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count > 10000000){
                        System.out.println("LowPriority is compele");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Thread high = new HighPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
