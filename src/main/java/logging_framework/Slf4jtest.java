package logging_framework;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Administrator on 2017/1/16.
 */
public class Slf4jtest {
    public static void main(String[] args) {
        hello();


        // FATAL > ERROR > WARN > INFO > DEBUG
    }

    public static void hello() {
        Logger logger = LogManager.getLogger(Slf4jtest.class);

        String a = null;
        try {
            a.toString();
        } catch (Exception e) {
            logger.info("exception",e);
        }
    }

}
