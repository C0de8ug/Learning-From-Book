package Understanding_the_JVM_Advanced_Features_and_Best_Practices.chapter3;

/**
 * Created by codebug on 16-10-6.
 */
public class DynamicTenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4,allocation5;
        allocation1 = new byte[_1MB / 2];   // allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 2];   // allocation1+allocation2大于survivo空间一半

        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String args[]){
        testTenuringThreshold2();
    }
}
