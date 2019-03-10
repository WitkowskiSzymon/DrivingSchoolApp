package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.entity.Participant;
import pl.drivingschool.repository.ActivitiesRepository;
import pl.drivingschool.repository.ParticipantRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    ParticipantRepository participantRepository;


    @Autowired
    Validator validator;

    @Autowired
    ActivitiesRepository activitiesRepository;

    @ModelAttribute("activities")
    public Collection<Activities> kursy(){

        List<Activities> kursy2 = new ArrayList<>();

        kursy2.add(new Activities("Złoty"));
        kursy2.add(new Activities("Platynowy"));
        kursy2.add(new Activities("Diamentowy"));

        return kursy2;
    }


    // <----------------------------Dodawanie użytkownika------------------->

    @GetMapping("/add")
    public String showParticipant(Model model) {

        model.addAttribute("participant", new Participant());

        return "participant";

    }

    @PostMapping("/add")
    public String addParticipant(@ModelAttribute @Valid Participant participant, @ModelAttribute  Activities activities, BindingResult bindingResult) {

        Participant participant1 =  participantRepository.findByEmail(participant.getEmail());

        if (participant1 != null) {
            bindingResult.rejectValue("email","error.email","Juz istnieje taki uczestnik");

            return "participant";

        }else if (bindingResult.hasErrors()){

            return "participant";
        }

        else {

//            participant.setPassword(BCrypt.hashpw(participant.getPassword(), BCrypt.gensalt()));
            participantRepository.save(participant);

            activitiesRepository.save(activities);
            participant.setEnabled(1);

            return "home";


        }
    }


    //<-------------------Lista użytkowników---------------->

    @GetMapping("/all")
    public String allParticipants(Model model) {

        List<Participant> participantList = participantRepository.findAll();
        model.addAttribute("participants", participantList);

        return "participantList";
    }
}
