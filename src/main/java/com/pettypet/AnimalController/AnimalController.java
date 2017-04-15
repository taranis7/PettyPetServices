package com.pettypet.AnimalController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pettypet.model.Animal;
import com.pettypet.service.AnimalService;

@Controller
public class AnimalController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private AnimalService animalService;
    
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    @ResponseBody
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/animals", method=RequestMethod.GET)
    @ResponseBody
    public List<Animal> animals() {
        return animalService.findAll();
    }
}
