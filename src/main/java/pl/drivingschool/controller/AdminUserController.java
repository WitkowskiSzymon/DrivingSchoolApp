package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.entity.User;
import pl.drivingschool.repository.ActivitiesRepository;
import pl.drivingschool.repository.UserRepository;
import pl.drivingschool.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin/userAdm")
public class AdminUserController {

    @Autowired
    UserService userService;

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

    @GetMapping("/add")
    public String showUser(Model model) {

        model.addAttribute("user", new User());

        return "userAdm";

    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid User user, @ModelAttribute Activities activities, BindingResult bindingResult, String email) {

        if (validation(user, bindingResult, email)) {
            return "userAdm";
        } else {

            userService.createUser(user, activities);

            return "redirect:/admin";
        }
    }

    private Boolean validation(User user, BindingResult bindingResult, String email) {

        User foundUser = userService.validateUser(user, email);

        if (foundUser != null) {
            bindingResult.rejectValue("email", "error.email", "Juz istnieje taki uczestnik");

            return true;

        } else if (bindingResult.hasErrors()) {

            return true;

        } else {
            return false;

        }
    }

    @GetMapping("/update/{id}")
    public String findUserForUpdate(@PathVariable Long id, Model model) {

        User user = userService.findUserForUpdate(id);
        model.addAttribute("user", user);

        return "user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {

        userService.updateUser(id, user);

        return "redirect:../all";
    }

    @GetMapping("/all")
    public String allUsers(Model model) {

        List<User> userList = userService.findUsers();
        model.addAttribute("user", userList);

        return "userListAdm";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "redirect:../all";
    }
}
