package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by codebugcn on 17-2-3.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<TestPO> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            TestPO testPO = new TestPO();
            testPO.setName("h");
            testPO.setAge(i);
            list.add(testPO);
        }

        List<Long> ids = list.stream().map(TestPO::getAge).collect(Collectors.toList());
        System.out.println(ids);

    }
}
