package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.drivingschool.entity.User;
import pl.drivingschool.repository.ActivitiesRepository;
import pl.drivingschool.repository.UserRepository;
import pl.drivingschool.service.UserService;

import javax.validation.Validator;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @Autowired
    Validator validator;

    @Autowired
    ActivitiesRepository activitiesRepository;


    @GetMapping("/all")
    public String allParticipants(Model model) {

        List<User> userList = userService.findUsers();
        model.addAttribute("user", userList);

        return "userList";
    }
}
