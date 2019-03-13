package pl.drivingschool.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.entity.User;
import pl.drivingschool.repository.ActivitiesRepository;
import pl.drivingschool.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin/userAdm")
public class AdminUserController {

    @Autowired
    UserRepository userRepository;


    @Autowired
    Validator validator;

    @Autowired
    ActivitiesRepository activitiesRepository;

    @ModelAttribute("activities")
    public Collection<Activities> kursy() {

        List<Activities> kursy2 = new ArrayList<>();

        kursy2.add(new Activities("Złoty"));
        kursy2.add(new Activities("Platynowy"));
        kursy2.add(new Activities("Diamentowy"));

        return kursy2;
    }


    // <----------------------------Dodawanie użytkownika------------------->

    @GetMapping("/add")
    public String showParticipant(Model model) {

        model.addAttribute("user", new User());

        return "userAdm";

    }

    @PostMapping("/add")
    public String addParticipant(@ModelAttribute @Valid User user, @ModelAttribute  Activities activities, BindingResult bindingResult) {

        User user1 = userRepository.findByEmail(user.getEmail());

        if (user1 != null) {
            bindingResult.rejectValue("email", "error.email", "Juz istnieje taki uczestnik");

            return "userAdm";

        }
        else if (bindingResult.hasErrors()) {

            return "userAdm";
        } else {

           user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userRepository.save(user);

            activitiesRepository.save(activities);
            user.setEnabled(1);

            return "redirect:/admin";

        }
    }



    //<----------------Edycja użytkownika----------------->

    @GetMapping("/update/{id}")
    public String updateParticipant(@PathVariable Long id, Model model) {


        User user = userRepository.findUserById(id);
        model.addAttribute("user", user);

        return "user";
    }

    @PostMapping("/update/{id}")
    public String updateParticipant(@PathVariable Long id, @ModelAttribute User user) {

        userRepository.save(user);

        return "redirect:../all";

    }

    //<-------------------Lista użytkowników---------------->

    @GetMapping("/all")
    public String allParticipants(Model model) {

        List<User> userList = userRepository.findAll();
        model.addAttribute("user", userList);

        return "userListAdm";
    }

    //<------------------Usuwanie użytkownika-------------------->

    @GetMapping("/delete/{id}")
    public String deleteParticipant(@PathVariable Long id) {

        userRepository.deleteById(id);

        return "redirect:../all";
    }
}
