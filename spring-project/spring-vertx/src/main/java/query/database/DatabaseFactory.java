package query.database;


import query.config.QueryConfig;
import query.config.ServiceProperties;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
public class DatabaseFactory {

    public static IDatabase instance(QueryConfig queryConfig, ServiceProperties serviceProperties) {
        switch (serviceProperties.getDatabaseType()) {
            case DatabaseType.GBASE:
            case DatabaseType.RDS:
            case DatabaseType.ODPS:
            case DatabaseType.MYSQL:
                return new RdsDatabase(queryConfig, serviceProperties.getDatabase(), serviceProperties.getPoolMaxSize());
            default:
                return new RdsDatabase(queryConfig, serviceProperties.getDatabase(), serviceProperties.getPoolMaxSize());
        }
    }
}
