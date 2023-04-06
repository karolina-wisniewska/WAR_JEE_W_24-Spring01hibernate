package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
class AuthorController {

  private final AuthorService authorService;

  AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  // creates author
  @PostMapping(path = "/author")
  void save(@RequestParam String firstName, @RequestParam String lastName) {

    Author author = new Author();

    author.setFirstName(firstName);
    author.setLastName(lastName);

    authorService.save(author);
  }

  // gets author by id
  @GetMapping(path = "/author/{id}")
  String findById(@PathVariable Long id) {

    Author author = authorService.findById(id);

    return author != null ? author.toString() : "Nie znaleziono autora o podanym id " + id;
  }

  // gets all authors
  @GetMapping(path = "/authors", produces = "text/plain;charset=utf-8")
  String findAll(Model model) {

    model.addAttribute("authors", authorService.findAll());

    return "author/all";
  }

  // updates author
  @PutMapping(path = "/author/{id}")
  void update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName) {

    final Author author = authorService.findById(id);

    if (Objects.nonNull(author)) {
      author.setFirstName(firstName);
      author.setLastName(lastName);

      authorService.update(author);
    }
  }

  // deletes author by id
  @DeleteMapping(path = "/author/{id}")
  void deleteById(@PathVariable Long id) {
    authorService.deleteById(id);
  }

  @GetMapping("/author/add")
  public String showAddAuthorForm(Model model) {
    model.addAttribute("author", new Author());
    return "author/add";
  }

  @PostMapping("/author/add")
  public String processAddAuthorForm(@Valid Author author, BindingResult result) {
    if (result.hasErrors()) {
      return "author/add";
    }
    authorService.save(author);
    return "redirect:/authors";
  }

  @GetMapping("/author/edit")
  public String showUpdateAuthorForm(Model model, @RequestParam Long id) {
    model.addAttribute("author", authorService.findById(id));
    return "author/edit";
  }

  @PostMapping("/author/edit")
  public String processUpdateAuthorForm(@Valid Author author, BindingResult result) {
    if (result.hasErrors()) {
      return "author/edit";
    }
    authorService.update(author);
    return "redirect:/authors";
  }

}
