package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class SocketJSTest extends AbstractVerticle {
    public static void main(String[] args) {
        VertxRunner.runExample(SocketJSTest.class.getName(), false);
    }

    @Override
    public void start() {
        Router router = Router.router(vertx);
        SockJSHandler sockJSHandler = SockJSHandler.create(vertx);
        sockJSHandler.socketHandler(sockJSSocket -> {
            sockJSSocket.handler(sockJSSocket::write);
        });

        router.route("/socket/*").handler(sockJSHandler);
        vertx.createHttpServer().requestHandler(router::accept).listen(7777);

    }
}
