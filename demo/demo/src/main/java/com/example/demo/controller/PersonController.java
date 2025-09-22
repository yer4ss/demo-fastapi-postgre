package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("newPerson", new Person());
        return "index";
    }
    
    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/";
    }
}