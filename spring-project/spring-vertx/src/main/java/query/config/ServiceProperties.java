package query.config;

import java.io.Serializable;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class ServiceProperties implements Serializable {

    private String serviceName;
    private String databaseType;
    private String database;
    private String sql;
    private Integer poolMaxSize = 5;

    public String getServiceName() {
        return serviceName;
    }

    public ServiceProperties setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public ServiceProperties setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
        return this;
    }

    public String getSql() {
        return sql;
    }

    public ServiceProperties setSql(String sql) {
        this.sql = sql;
        return this;
    }

    public String getDatabase() {
        return database;
    }

    public ServiceProperties setDatabase(String database) {
        this.database = database;
        return this;
    }

    public Integer getPoolMaxSize() {
        return poolMaxSize;
    }

    public ServiceProperties setPoolMaxSize(Integer poolMaxSize) {
        this.poolMaxSize = poolMaxSize;
        return this;
    }
}
