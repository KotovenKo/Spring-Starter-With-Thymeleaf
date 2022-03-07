package com.kot.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "secondName", required = false) String secondName,
                            Model model){
//        String name = request.getParameter("name");
//        String secondName = request.getParameter("secondName");
        System.out.println("Hello " + name + " " + secondName);
        model.addAttribute("Message", "Hello " + name + " " + secondName);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage (){
        return "first/goodbye";

    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model){
        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "summ":
                result = a + b;
                break;
            case "substruction":
                result = a - b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return"first/calculator";
    }
}
