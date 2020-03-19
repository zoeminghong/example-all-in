package query.database;

import org.springframework.util.StringUtils;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
public abstract class AbstractDatabase implements IDatabase {

    @Override
    public void select(String database, String sql, String where, String groupBy, CallbackFunction callback) {
        if (StringUtils.hasLength(where)) {
            if (!where.substring(0, 3).toLowerCase().startsWith(SQLPattern.AND)) {
                where = SQLPattern.AND +" "+ where;
            }
            sql = sql.replace(SQLPattern.WHERE, where);
        }
        if (StringUtils.hasLength(groupBy)) {
            sql = sql.replace(SQLPattern.GROUP_BY, groupBy);
        }
        this.doSelect(database, sql, where, groupBy, callback);
    }

    abstract void doSelect(String database, String sql, String where, String groupBy, CallbackFunction callback);
}
