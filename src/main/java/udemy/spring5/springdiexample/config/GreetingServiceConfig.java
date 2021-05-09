package udemy.spring5.springdiexample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import udemy.spring5.pets.PetService;
import udemy.spring5.pets.PetServiceFactory;
import udemy.spring5.springdiexample.datasource.FakeDataSource;
import udemy.spring5.springdiexample.repositories.EnglishGreetingRepository;
import udemy.spring5.springdiexample.repositories.EnglishGreetingRepositoryImpl;
import udemy.spring5.springdiexample.services.*;

@EnableConfigurationProperties(UdemyConstructorConfig.class)
@ImportResource("classpath:spring-config.xml")
@Configuration
public class GreetingServiceConfig {
    @Bean
    FakeDataSource fakeDataSource(UdemyConstructorConfig udemyConstructorConfig)
    {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(udemyConstructorConfig.getUsername());
        fakeDataSource.setPassword(udemyConstructorConfig.getPassword());
        fakeDataSource.setJdbcurl(udemyConstructorConfig.getJdbcurl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory()
    {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory)
    {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory)
    {
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES","default"})
    @Bean("I18nService")
    I18nSpanishService i18nSpanishService()
    {
        return new I18nSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository()
    {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishService I18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishService(englishGreetingRepository);
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
}
