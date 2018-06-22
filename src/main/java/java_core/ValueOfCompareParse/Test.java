package java_core.ValueOfCompareParse;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/5/17.
 */
public class Test {
    public static void main(String[] args) {
        Double a = 16.65;


        System.out.println(BigDecimal.valueOf(a).multiply(new BigDecimal(100)).doubleValue());

//
//        BigDecimal h = BigDecimal.valueOf(32.8);
//        System.out.println(h.doubleValue());
    }
}
