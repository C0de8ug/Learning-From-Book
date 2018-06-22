package java_core.ValueOfCompareParse;

import java.time.Duration;
import java.time.Instant;

public class ValueOfCompareParse {
        public static String temp = "1";
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        for (int i = 0; i < 10; i++) {
            Instant start = Instant.now();
            for (int j = 0; j <2000000000; j++) {
                int a = Integer.valueOf(temp);
            }
            Instant end = Instant.now();
            System.out.println("valueoOf : " + String.valueOf(Duration.between(start,end)));
        }
    }

    public static void test2(){
        for (int i = 0; i < 10; i++) {
            Instant start = Instant.now();
            for (int j = 0; j <2000000000; j++) {
                int a = Integer.parseInt(temp);
            }
            Instant end = Instant.now();
            System.out.println("parseInt : " + String.valueOf(Duration.between(start,end)));
        }

    }
}
