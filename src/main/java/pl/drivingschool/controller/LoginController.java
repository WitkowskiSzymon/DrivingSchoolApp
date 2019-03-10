package pl.drivingschool.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.drivingschool.entity.Participant;
import pl.drivingschool.repository.ParticipantRepository;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("participant", new Participant());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid Participant participant, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        Participant participantDb = participantRepository.findByParticipantName(participant.getParticipantName());
        boolean isLogged = participantDb != null && BCrypt.checkpw(participant.getPassword(), participantDb.getPassword());
        if (!isLogged) {
            model.addAttribute("loginFailed", true);
            return "login";
        }

        return "home";
    }
}
