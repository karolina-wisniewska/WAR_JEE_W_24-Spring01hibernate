package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ValidationController {
  private final Validator validator;

  @RequestMapping("/validate")
  public String validateTest(Model model) {
    Book p2 = new Book();
    p2.setTitle("ala");
    Set<ConstraintViolation<Book>> violations = validator.validate(p2);
    if (!violations.isEmpty()) {
      for (ConstraintViolation<Book> constraintViolation : violations) {
        log.error(constraintViolation.getPropertyPath() + " "
                + constraintViolation.getMessage());
      }
      model.addAttribute("errors", violations);
    } else {
      // save object
    }
    return "book/validate";
  }
}
