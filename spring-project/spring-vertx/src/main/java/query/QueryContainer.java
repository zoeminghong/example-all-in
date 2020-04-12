package query;


import io.vertx.core.Vertx;
import query.config.QueryConfig;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class QueryContainer {

    private static ResponseContent responseContent;

    private static Vertx vertx;

    private static QueryConfig queryConfig;

    public static ResponseContent getResponseContent() {
        return responseContent;
    }

    public static void setResponseContent(ResponseContent responseContent) {
        QueryContainer.responseContent = responseContent;
    }

    public static Vertx getVertx() {
        return vertx;
    }

    public static void setVertx(Vertx vertx) {
        QueryContainer.vertx = vertx;
    }

    public static QueryConfig getQueryConfig() {
        return queryConfig;
    }

    public static void setQueryConfig(QueryConfig queryConfig) {
        QueryContainer.queryConfig = queryConfig;
    }

}
