package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showUsers(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("name", "Users:");
        model.addAttribute("users", userService.listUsersByCount(count));
        return "users";
    }
}
