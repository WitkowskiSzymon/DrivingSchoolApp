package pl.drivingschool.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping("/")
    public String home(){

        return "home";

    }

    @RequestMapping("/about")
    public String oNas(){

        return "about";
    }

    @RequestMapping("/contact")
    public String contact(){

        return "contact";
    }

    @RequestMapping("/gallery")
    public String gallery(){

        return "gallery";
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String admin(){

        return "admin";
    }
}
