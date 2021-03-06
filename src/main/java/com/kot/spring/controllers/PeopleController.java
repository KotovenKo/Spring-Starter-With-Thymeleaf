package com.kot.spring.controllers;


import com.kot.spring.DAO.PersonDAO;
import com.kot.spring.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/")
    public String starter(Model model){
       // model.addAttribute("people", personDAO.showNumberPerson(2));
        return "people/starter";
    }
    @GetMapping("/listbycounter")
    public String showByCounter(@RequestParam(value = "counter") int counter, Model model){
        model.addAttribute("people", personDAO.showNumberPerson(counter));
        return "people/listbycounter";
    }


    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
     @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create (@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/index";
    }
}
