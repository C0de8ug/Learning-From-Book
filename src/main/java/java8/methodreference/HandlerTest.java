package java8.methodreference;

/**
 * Created by codebug on 12/29/16.
 */
public class HandlerTest{



    public static void test(Handler handler) {
        handler.handle();
    }


    public static class HandlerImpl implements Handler{

        @Override
        public void handle() {
            System.out.println("HandlerImpl");
        }

        public void handler2(){
            System.out.println("handler2");
        }


    }

    public static void main(String args[]){

        HandlerImpl handler = new HandlerImpl();
        test(handler);
        test(()->{System.out.println("Lambda Impl");});


    }
}
