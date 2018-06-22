package Understanding_the_JVM_Advanced_Features_and_Best_Practices.chapter3;

/**
 * Created by codebug on 16-10-6.
 */
public class TenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void testTenuringThreshold(){
        byte[] allocation1 = new byte[_1MB];
        byte[] allocation2 = new byte[_1MB];

        byte[] allocation3 = new byte[7 * _1MB];




    }

    public static void main(String args[]){
        testTenuringThreshold();
    }

}

