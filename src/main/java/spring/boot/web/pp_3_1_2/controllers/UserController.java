package spring.boot.web.pp_3_1_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.boot.web.pp_3_1_2.models.User;
import spring.boot.web.pp_3_1_2.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("value", userService.getAllUsers());
        model.addAttribute("user", new User());

        return "users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);

        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));

        return "/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/";
    }
}
