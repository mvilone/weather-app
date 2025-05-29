package com.example.WeatherApp.controller;

import com.example.WeatherApp.domain.userInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class userInputController {

    @GetMapping("/index")
    public String ViewForm(Model model){
        model.addAttribute("userInput", new userInput());
        return "index";
    }

    @PostMapping("/userInput")
    public String addForm(@ModelAttribute userInput input, BindingResult result, Model model){
        model.addAttribute("inputs", input);

        //The location, username, and password are being set in the index.html file, which is why we're able to use the getters
        //(the print statements just shows that it's getting the correct information. (Can delete))
        //System.out.println("Location: " + input.getLocation());
        //System.out.println("username: " + input.getUsername());
        //System.out.println("password: " + input.getPassword());

        //returns "weatherDisplay" because this is the name of the html file (new webpage) that will be displayed
        return "weatherDisplay";
    }
}
