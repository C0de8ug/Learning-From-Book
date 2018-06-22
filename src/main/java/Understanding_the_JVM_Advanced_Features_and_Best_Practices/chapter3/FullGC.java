package Understanding_the_JVM_Advanced_Features_and_Best_Practices.chapter3;

/**
 * Created by codebug on 16-10-7.
 */
public class FullGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4,allocation5,allocation6;
        allocation1 = new byte[7 * _1MB];
        allocation2 = new byte[7 * _1MB];

        allocation1 = null;
        allocation3 = new byte[7 * _1MB];
    }

    public static void main(String args[]){
        testAllocation();
    }
}
