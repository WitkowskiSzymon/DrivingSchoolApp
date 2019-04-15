package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.service.ActivitiesService;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class ActivitiesController {


    @Autowired
    ActivitiesService activitiesService;


    @GetMapping("/add")
    public String showActivity(Model model) {

        model.addAttribute("activities", new Activities());

        return "courses";
    }

    @PostMapping("/add")
    public String addActivity(@ModelAttribute Activities activities) {

        activitiesService.createActivity(activities);

        return "redirect:all";
    }

    @GetMapping("/all")
    public String allActivity(Model model) {

        List<Activities> activitiesList = activitiesService.findActivities();
        model.addAttribute("activities", activitiesList);

        return "activityList";
    }
}
