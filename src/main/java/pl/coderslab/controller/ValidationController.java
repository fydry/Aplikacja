package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.domain.Item;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationController {
    private final static Logger logger = LoggerFactory.getLogger(ValidationController.class);
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public String validationTest(Model model) {
        Item item = new Item();
        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        model.addAttribute("violations", violations);

        if (!violations.isEmpty()) {
            violations.forEach(v -> logger.debug("{} {}", v.getPropertyPath(), v.getMessage()));
        } else {
            // save object
        }
        return "validateResult";
    }
}
