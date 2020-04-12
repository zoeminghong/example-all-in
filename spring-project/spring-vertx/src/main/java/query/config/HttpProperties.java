package query.config;


import query.common.BaseConstants;

import java.io.Serializable;

/**
 * Created on 2020-03-16.
 *
 * @author 迹_Jason
 */
public class HttpProperties implements Serializable {

    private Integer port = 7777;
    private String allowOrigin = BaseConstants.STAR_SEPARATOR;
    private Boolean authEnable = true;

    public Integer getPort() {
        return port;
    }

    public HttpProperties setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getAllowOrigin() {
        return allowOrigin;
    }

    public HttpProperties setAllowOrigin(String allowOrigin) {
        this.allowOrigin = allowOrigin;
        return this;
    }

    public Boolean getAuthEnable() {
        return authEnable;
    }

    public HttpProperties setAuthEnable(Boolean authEnable) {
        this.authEnable = authEnable;
        return this;
    }
}
