package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.repository.ActivitiesRepository;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class ActivitiesController {

    @Autowired
    ActivitiesRepository activitiesRepository;



    // <----------------------------Dodawanie kursow------------------->

    @GetMapping("/add")
    public String showActivity(Model model) {

        model.addAttribute("activities", new Activities());

        return "courses";

    }

    @PostMapping("/add")
    public String addActivity(@ModelAttribute Activities activities) {

        activitiesRepository.save(activities);

        return "redirect:all";

    }


//<-------------------Lista kursow---------------->

    @GetMapping("/all")
    public String allActivity(Model model) {

        List<Activities> activitiesList = activitiesRepository.findAll();
        model.addAttribute("activities", activitiesList);

        return "activityList";
    }
}
