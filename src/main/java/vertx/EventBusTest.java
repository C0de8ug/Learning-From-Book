package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class EventBusTest extends AbstractVerticle {
    public static void main(String[] args) {
        VertxRunner.runExample(EventBusTest.class.getName(), false);
    }

    @Override
    public void start() {
        Router router = Router.router(vertx);

        BridgeOptions options =
            new BridgeOptions().addInboundPermitted(new PermittedOptions().setAddressRegex("c2s*"))
                .addOutboundPermitted(new PermittedOptions().setAddressRegex("s2c*"));
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx).bridge(options);
        router.route("/eventbus/*").handler(sockJSHandler);

        vertx.eventBus().consumer("c2s").handler(msg -> {
            vertx.eventBus().send("s2c", "Send Requested");
        });

        router.route().handler(StaticHandler.create());
        vertx.createHttpServer().requestHandler(router::accept).listen(12345);

    }
}
