package com.example.spotify.controllers;

import com.example.spotify.controllers.services.UserService;
import com.example.spotify.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/premium")
public class UserController {
    @Autowired
    UserService us;
    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("users", us.getAll());
        return "UserIndex";
    }

    @GetMapping("/{username}")
    public String getByUsername(@PathVariable String username, Model model){
        model.addAttribute("users", us.getByUserName(username));
        return "UserIndex";
    }

    @GetMapping("/save")
    public String setUser(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "UserCreate";
    }
    @PostMapping("/save")
    public String setUser(@ModelAttribute User user){
        us.save(user);
        return "redirect:/users";
    }
}