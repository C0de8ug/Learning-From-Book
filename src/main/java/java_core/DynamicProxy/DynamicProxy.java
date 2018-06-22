package java_core.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by codebug on 16-12-10.
 */
public class DynamicProxy{
    public static void main(String args[]){
        Person person = new Person();
        Handler handler = new Handler(person);
        Speak proxy = (Speak) Proxy.newProxyInstance(Speak.class.getClassLoader(), new Class[] { Speak.class } , handler);
        proxy.speak();
    }
}

class Handler implements InvocationHandler{
    Object obj;

    Handler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("before methodreference");
        Object result = method.invoke(obj,objects);
        System.out.println("after methodreference");
        return result;
    }
}
