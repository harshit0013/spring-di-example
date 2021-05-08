package udemy.spring5.springdiexample.services;


import udemy.spring5.springdiexample.repositories.EnglishGreetingRepository;

public class I18nEnglishService implements GreetingService{
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello - English";
    }
}
