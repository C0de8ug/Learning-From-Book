package UnitTest;

import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTest {
    static List mockedList = mock(List.class);

    public static void main(String args[]) {
//        behaviourMock();
//        verifyBehaviour();
        mockFunctionInAnotherFunction();
    }

    public static void behaviourMock() {
        when(mockedList.get(0)).thenReturn("hello");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
//        when(mockedList.get(anyInt())).thenReturn("get int");
        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(2));
    }

    public static void verifyBehaviour() {
        //behaviour verify
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();

        //param verify
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");
        verify(mockedList, times(2)).add("twice");
//        verify(mockedList,times(3)).add("twince");
        verify(mockedList, never()).add("never add once before");
//        verify(mockedList,atLeast(2)).add("once");
    }

    public static void mockFunctionInAnotherFunction() {
        final MockitoTest testClass = Mockito.spy(new MockitoTest());
        Mockito.when(testClass.innerInvocation()).thenReturn("I am mockito");
        testClass.forTest();
    }

    public void forTest() {
        String ret = innerInvocation();
        System.out.println(ret);
    }

    public void forTest2() {
        Test test = new Test();
        test.show();
    }

    public String innerInvocation() {
        return "Hello World";
    }
}
