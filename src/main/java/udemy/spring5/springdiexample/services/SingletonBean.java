package udemy.spring5.springdiexample.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public SingletonBean() {
        System.out.println("Singleton bean is being created!");
    }

    public String getMyScope()
    {
        return "I am Singleton";
    }
}
