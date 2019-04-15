package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.drivingschool.entity.Instructor;
import pl.drivingschool.service.InstructorService;

import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @GetMapping("/all")
    public String allInstructors(Model model) {

        List<Instructor> instructorList = instructorService.findInstructors();
        model.addAttribute("instructors", instructorList);

        return "instructorList";
    }
}
