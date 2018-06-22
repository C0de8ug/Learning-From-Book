package java_core.GenericVsObject;


/*
* the advantage to using generic
* 1.avoid ClassCastException
* 2.compile time class type test
* 3.obj<xxxx>.fun() better than ((xxx)obj).fun()
*
* */
public class GenericVsObject {

    public static void main(String[] args) {
        GenericClazz<String> genericClazz = new GenericClazz<>();
        genericClazz.setObj("Hello World");
        genericClazz.getObj().trim();

        ObjectClazz objectClazz = new ObjectClazz();
        objectClazz.setObj(1);
        String obj = (String) objectClazz.getObj();
        obj.trim();
    }


    static class GenericClazz<T>{
        T obj;

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }
    }

    static class ObjectClazz{
        Object obj;

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }
    }
}
