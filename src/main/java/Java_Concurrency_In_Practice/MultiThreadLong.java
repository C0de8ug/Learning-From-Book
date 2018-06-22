package main.java.Java_Concurrency_In_Practice;

/**
 * Created by codebug on 16-11-17.
 */
/*
* 32 bit will get randon number,because long varaible in 32 bit vm is not atomic operation
* */
public class MultiThreadLong {
    public static long t = 0;
    public static class ChangeT implements  Runnable{
        private long to;
        public ChangeT(long to){
            this.to = to;
        }

        @Override
        public void run(){
            while (true){
                MultiThreadLong.t = to;
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public static class ReadT implements Runnable{
            @Override
            public void run() {
                while(true){
                    long tmp = MultiThreadLong.t;
                    if(tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L)
                        System.out.println(tmp);
                }
            }
        }

        public static void main(String[] args){
            new Thread(new ChangeT(111L)).start();
            new Thread(new ChangeT(-999L)).start();
            new Thread(new ChangeT(333L)).start();
            new Thread(new ChangeT(-444L)).start();
            new Thread(new ReadT()).start();
        }
    }

}
