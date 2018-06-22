package Java_Concurrency_In_Practice;

/**
 * Created by codebug on 16-11-12.
 */
public class SynchronizedTest {

    static class Bank{
        int a = 0;

        public void add (){
            synchronized (this){
                a++;
                System.out.println("add" + a);
            }
        }

        public void dec(){
            synchronized (this){
                a--;
                System.out.println("dec" + a);
            }
        }

    }

    static class TaskA implements Runnable {
        Bank bank;
        TaskA(Bank bank){
            this.bank = bank;
        }
        @Override
        public void run() {
            bank.add();
        }
    }

    static class TaskB implements Runnable{
        Bank bank;
        TaskB(Bank bank){
            this.bank = bank;
        }

        @Override
        public void run() {
            bank.dec();
        }
    }


    public static void main(String args[]){
        Bank bank =  new Bank();
        TaskA taskA = new TaskA(bank);
        TaskB taskB = new TaskB(bank);


        for (int i = 0;i < 10;i++){
            Thread threadA = new Thread(taskA);
            Thread threadB = new Thread(taskB);
            threadA.start();
            threadB.start();
        }
    }
}
