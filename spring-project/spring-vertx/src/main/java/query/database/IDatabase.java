package query.database;


import query.config.QueryConfig;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
public interface IDatabase {

    void init(QueryConfig queryConfig, String database, Integer poolMaxSize);

    void select(String database, String sql, String where, String groupBy, CallbackFunction callback);
}
