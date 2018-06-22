package Understanding_the_JVM_Advanced_Features_and_Best_Practices.chapter2;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM{
    static class OOMOBject{};

    public static void main (String args[]){
        List<OOMOBject> list = new ArrayList<OOMOBject>();
        while (true){
            list.add(new OOMOBject());
        }
    }

}