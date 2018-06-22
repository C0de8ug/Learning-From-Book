package java8.lambda;


import logging_framework.Slf4jtest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by codebug on 12/28/16.
 */
public class LambdaStackTrace {
    static Logger logger = LogManager.getLogger(Slf4jtest.class);

    public static void processPost(Handler<AsynResult> handler){
        handler.handle();
    }

    public static void main(String args[]) {
        try {
            processPost(() -> {
                String temp = null;
                temp.equals("");
            });
        } catch (Exception e) {
            logger.info("Exception", e);
        }

    }
}
