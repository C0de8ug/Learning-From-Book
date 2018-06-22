package java8.lambda;


/**
 * Created by codebug on 12/28/16.
 */
public class HandlerTest {

    public static void processPost(Handler<AsynResult> handler){
        System.out.println("processPost");
        handler.handle();
        System.out.println("");
    }

    public static void processPost2(HandlerHasParam<AsynResult> handler){
        System.out.println("processPost2");
        AsynResult asynResult = new AsynResult("AsynResult");
        handler.handle(asynResult);
        System.out.println("");
    }
    public static void processPost3(StaticHandler handler){
        System.out.println("processPost3");
        handler.handle();
    }
    public static void main(String args[]) {
        processPost(()->{System.out.println("lambda expression");});
        processPost2((ret)->{System.out.println(ret);});
        processPost3(HandlerNotFunctionInterface::handle);
        //other ways to use methodreference reference
    }
}
