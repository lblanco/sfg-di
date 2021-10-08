package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.datasource.SpringBootDatasource;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:datasource.properties")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String userName, @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}")String jdbcURL) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcURL(jdbcURL);
        return fakeDataSource;
    }

    @Bean
    SpringBootDatasource springBootDatasource(@Value("${sb.guru.username}") String userName, @Value("${sb.guru.password}") String password,
                                        @Value("${sb.guru.jdbcurl}")String jdbcURL) {
        SpringBootDatasource springBootDatasource = new SpringBootDatasource();
        springBootDatasource.setUserName(userName);
        springBootDatasource.setPassword(password);
        springBootDatasource.setJdbcURL(jdbcURL);
        return springBootDatasource;
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
