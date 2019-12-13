package pl.coderslab.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/users")
    public String listUsers(Model model, Pageable pageable) {
        List<User> page = userRepository.findAll();
        model.addAttribute("users", page);
        return "admin-users-list";
    }
    @GetMapping("/advices")
    public String adminAdvices() {
        return "admin-advices-list";
    }
    @GetMapping("/tags")
    public String adminTags() {
        return "admin-tags-list";
    }

}
