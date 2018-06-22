package java_core.Reflection;

import java_core.Annotation.CustomAnnotation;
import java_core.DynamicProxy.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by codebug on 16-12-10.
 */
public class Reflection {
    public static void main(String[] args) {
//        getClassObject();
//        getConstructor();
//        getMethod();
//        getField();
//        getAnnotation();
        invokeMethod();
    }

    public static void getClassObject() {
        try {
            Class<?> clz = Class.forName("java_core.DynamicProxy.Person");
            Class clz2 = Person.class;
            Person person = new Person();
            Class clz3 = person.getClass();


            System.out.println("1 :" + clz);
            System.out.println("2 :" + clz2);
            System.out.println("3 :" + clz3);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getConstructor() {
        try {
            Class clz = Class.forName("java_core.DynamicProxy.Person");
            Constructor constructor = clz.getConstructor(new Class[]{int.class});
            System.out.println(constructor);

            Constructor[] constructorArry = clz.getDeclaredConstructors();
            System.out.println(constructorArry);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void getMethod() {
        try {
            Class clz = Class.forName("java_core.DynamicProxy.Person");
            Method method = clz.getMethod("speak", new Class[]{});
            System.out.println(method);
            Method[] methods = clz.getMethods();
            System.out.println(methods);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void getField() {
        try {
            Class clz = Class.forName("java_core.DynamicProxy.Person");
            Field field = clz.getField("name");
            System.out.println(field);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void getAnnotation() {
        try {
            Class clz = Class.forName("java_core.DynamicProxy.Person");
            Annotation annotation = clz.getAnnotation(CustomAnnotation.class);
            System.out.println(annotation);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethod() {
        Class clz = null;
        try {
            clz = Class.forName("java_core.DynamicProxy.Person");

            Method method = clz.getMethod("speak");
            try {
                method.invoke(clz.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
