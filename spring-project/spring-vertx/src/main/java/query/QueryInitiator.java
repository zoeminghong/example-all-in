package query;

import com.huayun.cube.query.config.QueryConfig;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
@Component
public class QueryInitiator {

    private final static Logger logger = LoggerFactory.getLogger(QueryInitiator.class);

    @Autowired
    private QueryConfig queryConfig;

    @PostConstruct
    public void deploy() {
        logger.info("Init Vertx...");
        Vertx vertx = Vertx.vertx(new VertxOptions()
                .setEventLoopPoolSize(queryConfig.getVertx().getEventLoopPoolSize())
                .setWorkerPoolSize(queryConfig.getVertx().getWorkerPoolSize())
                .setInternalBlockingPoolSize(queryConfig.getVertx().getInternalBlockingPoolSize())
                .setMaxWorkerExecuteTime(queryConfig.getVertx().getMaxWorkerExecuteTime())
                .setWarningExceptionTime(queryConfig.getVertx().getWarningExceptionTime())
        );
        vertx.createHttpServer(new HttpServerOptions()
                .setTcpKeepAlive(true))
                .requestHandler(new VertxHttpHandler())
                .listen(queryConfig.getHttp().getPort(), httpServerAsyncResult -> {
                    if (httpServerAsyncResult.succeeded()) {
                        logger.info("Vertx Http Server Started, port :" + queryConfig.getHttp().getPort());
                    } else {
                        logger.error("Vertx Http Server Start Fail", httpServerAsyncResult.cause());
                    }
                });
        QueryContainer.setResponseContent(new ResponseContent(queryConfig));
        QueryContainer.setQueryConfig(queryConfig);
        QueryContainer.setVertx(vertx);
    }
}
