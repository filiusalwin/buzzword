package nl.miwgroningen.cohort3.alwin.buzzword.demo.controller;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.Theme;
import nl.miwgroningen.cohort3.alwin.buzzword.demo.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */

public class HomeController {
    @Autowired
    ThemeRepository themeRepository;

    @GetMapping({"/home"})
    protected String home (Model model) {
        model.addAttribute("allThemes", themeRepository.findAll());
        model.addAttribute("theme", new Theme());
        return "home";
    }

}
