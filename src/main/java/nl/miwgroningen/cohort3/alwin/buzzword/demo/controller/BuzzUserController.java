package nl.miwgroningen.cohort3.alwin.buzzword.demo.controller;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.BuzzUser;
import nl.miwgroningen.cohort3.alwin.buzzword.demo.repository.BuzzUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class BuzzUserController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    BuzzUserRepository buzzUserRepository;

    @GetMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String showNewUserForm(Model model){
        model.addAttribute("user", new BuzzUser());
        return "userForm";
    }

    @PostMapping("/user/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("user") BuzzUser user, BindingResult result){
        if(result.hasErrors()){
            return "userForm";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            buzzUserRepository.save(user);
            return "redirect:/";
        }
    }
}
