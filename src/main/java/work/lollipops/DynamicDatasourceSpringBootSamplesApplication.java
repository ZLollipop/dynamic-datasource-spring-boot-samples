package work.lollipops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaohaoren
 */
@SpringBootApplication
@MapperScan("work.lollipops.mapper")
public class DynamicDatasourceSpringBootSamplesApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceSpringBootSamplesApplication.class, args);
    }
}
