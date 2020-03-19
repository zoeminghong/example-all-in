package query.dto;

import java.io.Serializable;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class Query implements Serializable {
    private String where;
    private String groupBy;

    public String getWhere() {
        return where;
    }

    public Query setWhere(String where) {
        this.where = where;
        return this;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public Query setGroupBy(String groupBy) {
        this.groupBy = groupBy;
        return this;
    }
}
