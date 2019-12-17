package pl.coderslab.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.model.Advice;
import pl.coderslab.model.Tag;
import pl.coderslab.model.User;
import pl.coderslab.service.AdviceService;
import pl.coderslab.service.TagService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final AdviceService adviceService;
    private final TagService tagService;

    public AdminController(UserService userService, AdviceService adviceService, TagService tagService) {
        this.userService = userService;
        this.adviceService = adviceService;
        this.tagService = tagService;
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
    public String adminAdvices(Model model, Pageable pageable) {
        List<Advice> page = adviceService.findAll();
        model.addAttribute("advices", page);
        return "admin-advices-list";
    }

    @GetMapping("/advices/add")
    public String addAdvice(Model model) {
        model.addAttribute("advice", new Advice());
        return "admin-advices-add";
    }

    @PostMapping("/advices/add")
    public String addAdvicePost(@ModelAttribute @Valid Advice advice, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "admin/advices/add";
        }
        redirectAttributes.addFlashAttribute("message", "Advice added correctly");

        adviceService.save(advice);

        return "redirect:/admin/advices";
    }

    @GetMapping("/advices/delete/{id}")
    public String removeAdvice(@PathVariable long id) {
        adviceService.delete(adviceService.getOne(id));
        return "redirect:/admin/advices";
    }

    @GetMapping("/tags")
    public String adminTags(Model model, Pageable pageable) {
        List<Tag> page = tagService.findAll();
        model.addAttribute("tags", page);
        return "admin-tags-list";
    }

    @GetMapping("/tags/add")
    public String addTag(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin-tags-add";
    }

    @PostMapping("/tags/add")
    public String addTagPost(@ModelAttribute @Valid Tag tag, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "admin/tags/add";
        }
        redirectAttributes.addFlashAttribute("message", "Tag added correctly");

        tagService.save(tag);

        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/delete/{id}")
    public String removeTag(@PathVariable long id) {
        tagService.delete(tagService.getOne(id));
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/edit/{id}")
    public String editTag(Model model, @PathVariable long id){
        model.addAttribute("tag", tagService.getOne(id));
        return "admin-tags-edit";
    }

    @PostMapping("/tags/edit/{id}")
    public String editTagsPost(@ModelAttribute @Valid Tag tag, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "admin/tags/edit/{id}";
        }
        redirectAttributes.addFlashAttribute("message", "Tag changed correctly");
        tagService.save(tag);
        return "redirect:/admin/tags";


    }

}
