package spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"spring_boot"})
@EnableJpaRepositories(basePackages = "spring_boot.dao")
//@PropertySource("classpath:db.properties")
@EnableWebMvc
@EnableTransactionManagement
@EntityScan(basePackages = "spring_boot.model")
public class AppSpringBoot {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "db");
        SpringApplication.run(AppSpringBoot.class, args);
    }
}
