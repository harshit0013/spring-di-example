package udemy.spring5.springdiexample.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String sayGreeting() {
        return "Hello - English";
    }
}
