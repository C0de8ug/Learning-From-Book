package Java_Concurrency_In_Practice;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by codebug on 16-11-20.
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinDemo(long start,long end){
        this.start = start;
        this.end = end;
    }

    public Long compute(){
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute){
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        }else{
            long step = (start + end) / 100;
            ArrayList<ForkJoinDemo> subTasks = new ArrayList<ForkJoinDemo>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end){
                    lastOne = end;
                }
                ForkJoinDemo subTask = new ForkJoinDemo(pos,lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (ForkJoinDemo t : subTasks){
                sum += t.join();
            }
        }
        return sum;
    }

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0,200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum=" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
