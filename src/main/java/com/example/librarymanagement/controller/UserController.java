package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.User;
import com.example.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(@RequestParam(name = "userId", required = false) Integer userId, Model model) {
        if (userId != null) {
            User user = userService.getUserById(userId);
            if (user != null) {
                model.addAttribute("user", user);
            } else {
                model.addAttribute("errorMessage", "User not found with ID: " + userId);
            }
        }
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/viewAllUsers")
    public String viewAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email, 
                          @RequestParam String role, Model model) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setRole(role);
        userService.saveUser(newUser);
        model.addAttribute("successMessage", "User added successfully.");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam int userId, Model model) {
        userService.deleteUserById(userId);
        model.addAttribute("successMessage", "User deleted successfully.");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public Map<String, Object> getUser(@RequestParam int userId) {
        Map<String, Object> response = new HashMap<>();
        User user = userService.getUserById(userId);
        if (user != null) {
            response.put("editUser", user);
        } else {
            response.put("errorMessage", "User not found with ID: " + userId);
        }
        return response;
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam int id, @RequestParam String name, @RequestParam String email,
                           @RequestParam String role, Model model) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setRole(role);
            userService.saveUser(user);
            model.addAttribute("successMessage", "User updated successfully.");
        } else {
            model.addAttribute("errorMessage", "User not found with ID: " + id);
        }
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}
