package java_core.DynamicProxy;

import java_core.Annotation.CustomAnnotation;

/**
 * Created by codebug on 16-12-10.
 */
public class Person implements Speak{

    public String name;
    public int age;

    @CustomAnnotation
    public void speak(){
        System.out.println("Hello World!");
    }

    public Person(String name){
        this.name = name;
    }

    public Person(){

    }

    public Person(int age){
        this.age = age;
    }
}
