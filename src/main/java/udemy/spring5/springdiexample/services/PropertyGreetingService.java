package udemy.spring5.springdiexample.services;


public class PropertyGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
