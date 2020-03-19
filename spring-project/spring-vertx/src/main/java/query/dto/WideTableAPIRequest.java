package query.dto;

import java.io.Serializable;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class WideTableAPIRequest implements Serializable {

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务查询条件
     */
    private Query query;

    /**
     * 权限配置，预留
     */
    private String acl;

    public String getServiceName() {
        return serviceName;
    }

    public WideTableAPIRequest setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public Query getQuery() {
        return query;
    }

    public WideTableAPIRequest setQuery(Query query) {
        this.query = query;
        return this;
    }

    public String getAcl() {
        return acl;
    }

    public WideTableAPIRequest setAcl(String acl) {
        this.acl = acl;
        return this;
    }
}


