package udemy.spring5.springdiexample.controllers;

import org.springframework.stereotype.Controller;
import udemy.spring5.springdiexample.services.GreetingService;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello()
    {
        return greetingService.sayGreeting();
    }
}
