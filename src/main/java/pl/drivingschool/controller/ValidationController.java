package pl.drivingschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.drivingschool.ValidationError;
import pl.drivingschool.entity.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/validate")
    public String validate(Model model) {
        User user = new User();
        Set<ConstraintViolation<User>> errors = validator.validate(user);

        List<ValidationError> validationErrors = new ArrayList<>();
        for (ConstraintViolation<User> error : errors) {
            ValidationError validationError = new ValidationError(error.getPropertyPath().toString(), error.getMessage());
            validationErrors.add(validationError);
        }
        model.addAttribute("errors", validationErrors);
        return "validate";
    }
}
