package com.gmail.yuramitryahin.controller;

import com.gmail.yuramitryahin.entity.User;
import com.gmail.yuramitryahin.service.IncomingDataService;
import com.gmail.yuramitryahin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final IncomingDataService incomingDataService;
    private final UserService userService;

    public UserController(IncomingDataService incomingDataService, UserService userService) {
        this.incomingDataService = incomingDataService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/get-and-save-users")
    public String getAndSaveUserData() {
        try {
            List<User> users = incomingDataService.getUserData();
            userService.saveAll(users);
            return "redirect:/users";
        }catch (RuntimeException exception){
            return "errorGettingOrSavingUsers";
        }
    }
}
