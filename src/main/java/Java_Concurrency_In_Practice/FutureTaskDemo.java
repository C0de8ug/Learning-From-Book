package Java_Concurrency_In_Practice;

import java.util.concurrent.*;

/**
 * Created by codebug on 16-11-26.
 */
public class FutureTaskDemo {
    static class RealData implements Callable<String> {
        private String para;

        public RealData(String para){
            this.para = para;
        }

        @Override
        public String call() throws Exception {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                sb.append(para);
            }
            Thread.sleep(3000);
            return sb.toString();
        }
    }

    public static void main(String args[]){

        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);

        try {
            System.out.println("here");
            System.out.println(future.get(1000,TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
