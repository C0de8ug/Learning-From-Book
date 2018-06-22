package Understanding_the_JVM_Advanced_Features_and_Best_Practices.chapter3;

/**
 * Created by codebug on 16-10-6.
 */
public class PretenureSize {
    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String args[]){
        testPretenureSizeThreshold();
    }
}
