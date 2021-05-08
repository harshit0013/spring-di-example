package udemy.spring5.springdiexample.controllers;

import org.springframework.stereotype.Controller;
import udemy.spring5.springdiexample.services.PetService;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
