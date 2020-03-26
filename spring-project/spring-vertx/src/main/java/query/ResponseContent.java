package query;

import com.ecfront.dew.common.$;
import com.ecfront.dew.common.Resp;
import io.vertx.core.http.HttpServerResponse;
import query.config.QueryConfig;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class ResponseContent {

    public static final String FLAG_AUTHORIZATION = "X-Auth";
    public static final String FLAG_PROXY = "X-Forwarded-For";

    private QueryConfig queryConfig;

    public ResponseContent(QueryConfig queryConfig) {
        this.queryConfig = queryConfig;
    }

    public void returnContent(HttpServerResponse response, Integer code, String res) {
        response.setStatusCode(code).putHeader("Content-Type", "application/json; charset=utf-8")
                .putHeader("Cache-Control", "no-cache")
                .putHeader("Access-Control-Allow-Origin", queryConfig.getHttp().getAllowOrigin())
                .putHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .putHeader("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, X-client," + ResponseContent.FLAG_AUTHORIZATION + "," + ResponseContent.FLAG_PROXY)
                .end(res);
    }

    public void successReturnContent(HttpServerResponse response, Resp<?> res) {
        returnContent(response, 200, $.json.toJsonString(res));
    }

    public void successReturnContent(HttpServerResponse response, String res) {
        returnContent(response, 200, $.json.toJsonString(res));
    }

    public void unauthorizedReturnContent(HttpServerResponse response, Resp<?> res) {
        returnContent(response, 401, $.json.toJsonString(res));
    }

    public void badRequestReturnContent(HttpServerResponse response, Resp<?> res) {
        returnContent(response, 400, $.json.toJsonString(res));
    }
}
