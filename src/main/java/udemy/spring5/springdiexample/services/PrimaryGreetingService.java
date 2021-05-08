package udemy.spring5.springdiexample.services;


public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World from the Primary bean";
    }
}
