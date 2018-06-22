package java_core.StaticVariable;

import java_core.StaticVariable.StaticVariable;

public class StaticVariableAccessTest {

    public static void main(String args[]){
        StaticVariable.REAL_NUMBER = 2;
        System.out.println(StaticVariable.REAL_NUMBER);
    }
}
