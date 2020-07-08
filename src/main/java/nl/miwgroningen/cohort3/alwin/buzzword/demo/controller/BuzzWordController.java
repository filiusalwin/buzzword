package nl.miwgroningen.cohort3.alwin.buzzword.demo.controller;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.BuzzWord;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.Theme;
import nl.miwgroningen.cohort3.alwin.buzzword.demo.repository.BuzzWordRepository;
import nl.miwgroningen.cohort3.alwin.buzzword.demo.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */
@Controller
public class BuzzWordController {
    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    BuzzWordRepository buzzwordRepository;

    /*@GetMapping("buzzwordOverview")
    protected String showBuzzwords(Model model) {
        model.addAttribute("allBuzzwords", buzzwordRepository.findByAllByThemeId({themeId});

    }

     */

    @GetMapping("/buzzword/{themeId}")
    protected String createBuzzword(@PathVariable("themeId") final Integer themeId, Model model) {
        Optional<Theme> theme = themeRepository.findById(themeId);
        if (theme.isPresent()) {
            List<BuzzWord> buzzword = buzzwordRepository.findByTheme(theme.get());
            model.addAttribute("allBuzzwords", buzzword);
            model.addAttribute("theme", theme.get());
            model.addAttribute("buzzword", new BuzzWord());
            return "buzzwordOverview";
        } else {
            return "redirect:/buzzwordOverview";
        }
    }

    @PostMapping("/buzzword/new")
    protected String saveOrUpdateBuzzword(@ModelAttribute("buzzword")BuzzWord buzzword, BindingResult result){
        if (!result.hasErrors()) {
            buzzwordRepository.save(buzzword);
        }
        return "redirect:/buzzwordOverview/" + buzzword.getTheme().getThemeId();
    }

}


