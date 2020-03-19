package query.database;

import com.ecfront.dew.common.$;
import com.ecfront.dew.common.Resp;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.huayun.cube.query.QueryContainer;
import com.huayun.cube.query.config.QueryConfig;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
public class RdsDatabase extends AbstractDatabase {

    private final static Logger logger = LoggerFactory.getLogger(RdsDatabase.class);

    private Map<String, MySQLPool> mysqlClientMap=new HashMap<>();

    public RdsDatabase(QueryConfig queryConfig, String database, Integer poolMaxSize) {
        init(queryConfig, database, poolMaxSize);
    }

    @Override
    public void init(QueryConfig queryConfig, String database, Integer poolMaxSize) {
        Map<String, MySQLPool> mySQLPoolMap = getMysqlClientMap();
        if (!mySQLPoolMap.containsKey(database)) {
            MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                    .setPort(queryConfig.getMysql().getPort())
                    .setHost(queryConfig.getMysql().getHost())
                    .setDatabase(database)
                    .setUser(queryConfig.getMysql().getUsername())
                    .setPassword(queryConfig.getMysql().getPassword());
            PoolOptions poolOptions = new PoolOptions()
                    .setMaxSize(poolMaxSize);
            mySQLPoolMap.put(database, MySQLPool.pool(QueryContainer.getVertx(),connectOptions, poolOptions));
        }
    }

    @Override
    public void doSelect(String database, String sql, String where, String groupBy, CallbackFunction callback) {
        logger.info("execute sql is {}",sql);
        mysqlClientMap.get(database).query(sql, ar -> {
            if (ar.succeeded()) {
                RowSet<Row> result = ar.result();
               ArrayNode arrayNode= $.json.createArrayNode();
                for(Row row:result){
                    ObjectNode objectNode= $.json.createObjectNode();
                    for(int i=0;i<result.columnsNames().size();i++){
                        objectNode.put(result.columnsNames().get(i),row.getValue(i).toString());
                    }
                    arrayNode.add(objectNode);
                }
                callback.result(Resp.success(arrayNode));
            } else {
                logger.error("Failure: " + ar.cause().getMessage());
                callback.result(Resp.badRequest(ar.cause().getMessage()));
            }
        });
    }

    public Map<String, MySQLPool> getMysqlClientMap() {
        return mysqlClientMap;
    }

    public void setMysqlClientMap(Map<String, MySQLPool> mysqlClientMap) {
        this.mysqlClientMap = mysqlClientMap;
    }
}
