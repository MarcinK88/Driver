package pl.coderslab.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/users")
    public String listUsers(Model model, Pageable pageable) {
        List<User> page = userService.findAll();
        model.addAttribute("users", page);
        return "admin-users-list";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "admin-users-add";
    }

    @PostMapping("/users/add")
    public String addUserPost(@ModelAttribute @Valid User user, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "admin/users/add";
        }
        redirectAttributes.addFlashAttribute("message", "User added correctly");

        userService.saveUser(user);

        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String remove(@PathVariable long id) {
        userService.delete(userService.getOne(id));
        return "redirect:/admin/users";
    }

    @GetMapping("/users/password/{id}")
    public String changePassword(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getOne(id));
        return "admin-users-password";
    }

    @PostMapping("/users/password/{id}")
    public String changePasswordPost(@ModelAttribute @Valid User user, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "admin/users/password/{id}";
        }
        redirectAttributes.addFlashAttribute("message", "Password changed correctly");
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(Model model, @PathVariable long id){
        model.addAttribute("user", userService.getOne(id));
        return "admin-users-edit";
    }

    @PostMapping("/users/edit/{id}")
    public String editUserPost(@ModelAttribute @Valid User user, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "admin/users/edit/{id}";
        }
        redirectAttributes.addFlashAttribute("message", "User changed correctly");
        userService.save(user);
        return "redirect:/admin/users";


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
