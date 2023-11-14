package com.ua.controller;

import com.ua.model.User;
import com.ua.serves.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/welcome")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public void create(@RequestBody User user){
        userService.create(user);
    }
    @GetMapping("/get/{userId}")
    public User getById(@PathVariable Long userId){
       return userService.getById(userId);
    }
    @GetMapping("/get")
    public List<User> getAll(){
       return userService.getAll();
    }
    @PutMapping("/update/{userId}")
    public User update(@PathVariable Long userId,@RequestBody User user){
        return userService.update(userId,user);
    }
    @DeleteMapping ("/delete/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }


}

