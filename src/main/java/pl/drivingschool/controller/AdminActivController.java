package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.drivingschool.entity.Activities;
import pl.drivingschool.service.ActivitiesService;

import java.util.List;

@Controller
@RequestMapping("/admin/courses")
public class AdminActivController {


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

    @GetMapping("/update/{id}")
    public String findActivitiesForUpdate(@PathVariable Long id, Model model) {

        Activities activities = activitiesService.findActivitiesForUpdate(id);
        model.addAttribute("activities", activities);

        return "courses" +
                "";
    }

    @PostMapping("/update/{id}")
    public String updateActivity(@PathVariable Long id, @ModelAttribute Activities activities) {

        activitiesService.updateActivities(id, activities);

        return "redirect:../all";
    }

    @GetMapping("/all")
    public String allActivity(Model model) {

        List<Activities> activitiesList = activitiesService.findActivities();
        model.addAttribute("activities", activitiesList);

        return "activityList";
    }

    @GetMapping("/delete/{id}")
    public String deleteActivity(@PathVariable Long id) {

        activitiesService.deleteActivity(id);

        return "redirect:../all";
    }
}
