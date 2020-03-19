package query.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
@Component
@ConfigurationProperties(prefix = "query")
public class QueryProperties {

    private ODPSProperties odps = new ODPSProperties();

    public ODPSProperties getOdps() {
        return odps;
    }

    public QueryProperties setOdps(ODPSProperties odps) {
        this.odps = odps;
        return this;
    }
}
