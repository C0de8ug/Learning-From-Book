package vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.function.Consumer;

public class VertxRunner {

    public static void runExample(String verticleID,
                                  boolean clustered) {
        runExample(verticleID,
                new VertxOptions().setClustered(clustered));
    }

    public static void runExample(String verticleID,
                                  VertxOptions options) {
        Consumer<Vertx> runner = (vertx) -> {
            try {
                vertx.deployVerticle(verticleID);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        };
        if (options.isClustered()) {
            Vertx.clusteredVertx(options, res -> {
                if (res.succeeded()) {
                    Vertx vertx = res.result();
                    runner.accept(vertx);
                } else {
                    res.cause().printStackTrace();
                }
            });
        } else {
            Vertx vertx = Vertx.vertx(options);
            runner.accept(vertx);
        }
    }

}