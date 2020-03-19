package query.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
@Component
@ConfigurationProperties(prefix = "query")
public class QueryConfig implements Serializable {

    private VertxProperies vertx = new VertxProperies();
    private HttpProperties http = new HttpProperties();
    private MysqlProperties mysql = new MysqlProperties();
    private Map<String,ServiceProperties> services = new HashMap<>();

    public VertxProperies getVertx() {
        return vertx;
    }

    public QueryConfig setVertx(VertxProperies vertx) {
        this.vertx = vertx;
        return this;
    }

    public HttpProperties getHttp() {
        return http;
    }

    public QueryConfig setHttp(HttpProperties http) {
        this.http = http;
        return this;
    }

    public Map<String, ServiceProperties> getServices() {
        return services;
    }

    public QueryConfig setServices(Map<String, ServiceProperties> services) {
        this.services = services;
        return this;
    }

    public MysqlProperties getMysql() {
        return mysql;
    }

    public QueryConfig setMysql(MysqlProperties mysql) {
        this.mysql = mysql;
        return this;
    }
}




