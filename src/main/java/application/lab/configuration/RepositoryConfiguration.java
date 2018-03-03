package application.lab.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"application.lab.domain"})
@EnableJpaRepositories(basePackages = {"application.lab.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
