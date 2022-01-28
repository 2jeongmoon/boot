package io.jeongjm.rest.controller;

import io.jeongjm.rest.entity.User;
import io.jeongjm.rest.mariadb.dao;
import io.jeongjm.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class userController {
    @Autowired dao smd;

    private final UserService userService;

    @PostMapping("/users")
    public String register(@RequestBody User newUser) {
        return userService.register(newUser);
    }

    @GetMapping("/users/{id}")
    public User find(@PathVariable String id) {
        return userService.find(id);
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PutMapping("/users")
    public void modify(@RequestBody User newUser) {

    }

    @RequestMapping("/member")
    public List<Map<String, ?>> getMessages() {
        return smd.selectAll();
    }

    @GetMapping("/member/{email}")
    public List<Map<String, ?>> getMessages(@PathVariable String id) {
        return smd.select();
    }
}
