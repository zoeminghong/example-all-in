package query.config;

import java.io.Serializable;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
public class MysqlProperties implements Serializable {
    private String host;
    private String username;
    private Integer port;
    private String password;

    public String getHost() {
        return host;
    }

    public MysqlProperties setHost(String host) {
        this.host = host;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public MysqlProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public MysqlProperties setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MysqlProperties setPassword(String password) {
        this.password = password;
        return this;
    }
}
