package query;

import com.ecfront.dew.common.$;
import com.ecfront.dew.common.Resp;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import query.config.ServiceProperties;
import query.database.DatabaseFactory;
import query.database.IDatabase;
import query.dto.WideTableAPIRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
public class VertxHttpHandler implements Handler<HttpServerRequest> {

    public static final String API_QUERY_V1 = "/api/query/wide-table";
    Logger logger = LoggerFactory.getLogger(VertxHttpHandler.class);

    @Override
    public void handle(HttpServerRequest request) {

        if (request.method().name().equals("OPTIONS")) {
            QueryContainer.getResponseContent().successReturnContent(request.response(), "");
        } else {
            //取真实ip地址
            String ip = getRealIP(request.headers(), request.remoteAddress().host());
            logger.info("Receive a request [{}][{}] , from {} ", request.method().name(), request.uri(), ip);
        }
        if (request.method() == HttpMethod.POST && request.path().startsWith(VertxHttpHandler.API_QUERY_V1)) {
            request.handler(buffer -> {
                WideTableAPIRequest wideTableAPIRequest = $.json.toObject(buffer.toString(), WideTableAPIRequest.class);
                Resp<Void> checkResult = checkRequestParam(wideTableAPIRequest);
                if (!checkResult.ok()) {
                    QueryContainer.getResponseContent().badRequestReturnContent(request.response(), checkResult);
                } else {
                    ServiceProperties serviceProperties = QueryContainer.getQueryConfig().getServices().get(wideTableAPIRequest.getServiceName());
                    IDatabase database = DatabaseFactory.instance(QueryContainer.getQueryConfig(),
                            serviceProperties);
                    database.select(serviceProperties.getDatabase(), serviceProperties.getSql(),
                            wideTableAPIRequest.getQuery().getWhere(), wideTableAPIRequest.getQuery().getGroupBy(),
                            result -> QueryContainer.getResponseContent().successReturnContent(request.response(), result));
                }
            });
        }
    }

    public Resp<Void> checkRequestParam(WideTableAPIRequest wideTableAPIRequest) {
        if (wideTableAPIRequest == null) {
            return Resp.badRequest("请求参数不能为空");
        }
        if (StringUtils.isEmpty(wideTableAPIRequest.getServiceName())) {
            return Resp.badRequest("服务名称不能为空");
        }
        if (!QueryContainer.getQueryConfig().getServices().containsKey(wideTableAPIRequest.getServiceName())) {
            return Resp.badRequest("服务名称不存在");
        }
        return Resp.success(null);
    }

    public String getRealIP(MultiMap header, String remoteAddr) {
        Map<String, String> requestHeader = new HashMap<>();
        header.forEach(v -> requestHeader.put(v.getKey().toLowerCase(), v.getValue()));
        if (requestHeader.containsKey("http_x_forwarded_for") && requestHeader.get("http_x_forwarded_for") != null && !requestHeader.get("http_x_forwarded_for").isEmpty())
            return requestHeader.get("http_x_forwarded_for");
        else if (requestHeader.containsKey("x-forwarded-for") && requestHeader.get("x-forwarded-for") != null && !requestHeader.get("x-forwarded-for").isEmpty())
            return requestHeader.get("x-forwarded-for");
        else if (requestHeader.containsKey("x-real-ip") && requestHeader.get("x-real-ip") != null && !requestHeader.get("x-real-ip").isEmpty())
            return requestHeader.get("x-real-ip");
        else if (requestHeader.containsKey("wl-proxy-client-ip") && requestHeader.get("wl-proxy-client-ip") != null && !requestHeader.get("wl-proxy-client-ip").isEmpty())
            return requestHeader.get("wl-proxy-client-ip");
        else if (requestHeader.containsKey("x-forwarded-host") && requestHeader.get("x-forwarded-host") != null && !requestHeader.get("x-forwarded-host").isEmpty())
            return requestHeader.get("x-forwarded-host");
        else
            return remoteAddr;

    }
}