package udemy.spring5.springdiexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import udemy.spring5.springdiexample.services.*;

@Configuration
public class GreetingServiceConfig {
    @Profile({"ES","default"})
    @Bean("I18nService")
    I18nSpanishService i18nSpanishService()
    {
        return new I18nSpanishService();
    }
    @Profile("EN")
    @Bean
    I18nEnglishService I18nService() {
        return new I18nEnglishService();
    }
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService()
    {
        return new PrimaryGreetingService();
    }
    @Bean
    PropertyGreetingService propertyGreetingService()
    {
        return new PropertyGreetingService();
    }
    @Bean
    SetterGreetingService setterGreetingService()
    {
        return new SetterGreetingService();
    }
    @Bean
    ConstructorGreetingService constructorGreetingService()
    {
        return new ConstructorGreetingService();
    }
}
