package nl.miwgroningen.cohort3.alwin.buzzword.demo.controller;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.Theme;
import nl.miwgroningen.cohort3.alwin.buzzword.demo.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */
@Controller
public class ThemeController {

    @Autowired
    ThemeRepository themeRepository;

    @GetMapping({"/", "/theme"})
    protected String showThemes(Model model){
        model.addAttribute("allThemes", themeRepository.findAll());
        model.addAttribute("theme", new Theme());
        return "themeOverview";
    }

    @PostMapping("/theme/new")
    protected String saveOrUpdateTheme(@ModelAttribute("theme") Theme theme, BindingResult result){
        if (result.hasErrors()){
            return "themeOverview";
        } else {
            themeRepository.save(theme);
            return "redirect:/theme";
        }
    }

}
