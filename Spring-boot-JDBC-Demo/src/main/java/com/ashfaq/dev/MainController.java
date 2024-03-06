/**
 * 
 */
package com.ashfaq.dev;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainController {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/world")
                .username("root")
                .password("admin")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
