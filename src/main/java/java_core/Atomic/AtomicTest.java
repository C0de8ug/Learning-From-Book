package java_core.Atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicTest {

    public static void main(String args[]) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(true);

        //if the compare value is not equals expect ,will return false
        System.out.println(atomicBoolean.compareAndSet(false, false));

        System.out.println(atomicBoolean.compareAndSet(true, false));

    }
}
