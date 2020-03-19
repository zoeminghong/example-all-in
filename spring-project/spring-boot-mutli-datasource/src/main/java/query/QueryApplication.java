package query;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 2020-03-17.
 *
 * @author 迹_Jason
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class QueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class,args);
    }
}
