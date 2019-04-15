package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.drivingschool.entity.Instructor;
import pl.drivingschool.repository.InstructorRepository;
import pl.drivingschool.service.InstructorService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin/instructor")
public class AdminInstrucController {

    @Autowired
    InstructorService instructorService;

    @Autowired
    InstructorRepository instructorRepository;


    @GetMapping("/add")
    public String showInstructor(Model model) {

        model.addAttribute("instructor", new Instructor());

        return "instructor";
    }

    @PostMapping("/add")
    public String addInstructor(@ModelAttribute @Valid Instructor instructor, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "instructor";
        } else {
            instructorService.createInstructor(instructor);

            return "redirect:all";
        }
    }

    @GetMapping("/update/{id}")
    public String findInstructorForUpdate(@PathVariable Long id, Model model) {


        Instructor instructor= instructorService.findInstructorForUpdate(id);
        model.addAttribute("instructor", instructor);

        return "instructor";
    }

    @PostMapping("/update/{id}")
    public String updateInstructor(@PathVariable Long id, @ModelAttribute Instructor instructor) {

        instructorService.updateInstructor(id, instructor);

        return "redirect:../all";
    }

    @GetMapping("/all")
    public String allInstructors(Model model) {

        List<Instructor> instructorList = instructorService.findInstructors();
        model.addAttribute("instructors", instructorList);

        return "instructorListAdm";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable Long id) {

        instructorService.deleteInstructor(id);

        return "redirect:../all";
    }
}
