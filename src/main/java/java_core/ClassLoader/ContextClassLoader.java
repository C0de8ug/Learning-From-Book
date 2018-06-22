package java_core.ClassLoader;

/**
 * Created by Administrator on 2017/1/18.
 */
public class ContextClassLoader {

    public static void main(String args[]){
        //TODO  搞不懂getClass().getClassLoader()与Thread.currentThread().getContextClassLoader()的区别
        ContextClassLoader contextClassLoader = new ContextClassLoader();
        contextClassLoader.getClazz();
    }

    public void getClazz(){
        ClassLoader classLoader1 = getClass().getClassLoader();
        ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);
        System.out.println(classLoader2);
    }
}
