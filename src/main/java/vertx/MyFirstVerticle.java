package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class MyFirstVerticle extends AbstractVerticle {

    public static void main(String args[]) {
        String temp  = "";
        for (int i = 0; i < 1; i++) {
            temp += "100000000000000000000000000000000000000000";
        }
        final String temp2 = temp;
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end(temp2)).listen(8989);
    }
}