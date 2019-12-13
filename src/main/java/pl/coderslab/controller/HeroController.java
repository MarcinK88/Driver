package pl.coderslab.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.repository.HeroRepository;
import pl.coderslab.model.Hero;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hero")
public class HeroController {

    private final HeroRepository heroRepository;


    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }


    @RequestMapping("/list")
    public String listPage(Model model, Pageable pageable) {
        Page<Hero> page = heroRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "hero/list-page";
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getAllHeroes(Pageable pageable) {
        Page<Hero> heroes = heroRepository.findAll(pageable);
        return new ResponseEntity<>(heroes.getContent(), HttpStatus.OK);
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id) {
        heroRepository.delete(heroRepository.getOne(id));
        return "redirect:/hero/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("hero", new Hero());
        return "hero/add";
    }

    @PostMapping("/add")
    public String addPersonPerform(@ModelAttribute @Valid Hero hero, BindingResult result,
                                   RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "hero/add";
        }

        redirectAttributes.addFlashAttribute("message", "Hero dodany prawidłowo ");

        heroRepository.save(hero);
        return "redirect:/hero/list";
    }

}
