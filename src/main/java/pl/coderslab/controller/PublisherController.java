package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

@Controller
@RequiredArgsConstructor
public class PublisherController {

  private final PublisherService publisherService;

  @GetMapping("/publisher/add")
  public String showAddPublisherForm(Model model) {
    model.addAttribute("publisher", new Publisher());
    return "publisher/add";
  }

  @PostMapping("/publisher/add")
  public String processAddPublisherForm(Publisher publisher) {
    publisherService.save(publisher);
    return "redirect:/publishers";
  }

  @GetMapping("/publisher/{id}")
  public String getPublisher(@PathVariable Long id) {
    Publisher publisher = publisherService.findById(id);
    return publisher.toString();
  }

  @GetMapping(value = "/publishers", produces = "text/plain; charset=utf-8")
  public String getPublishers(Model model) {
    model.addAttribute("publishers", publisherService.findAll());
    return "publisher/all";
  }

  @GetMapping("/publisher/edit/{id}")
  public String showUpdatePublisherForm(Model model, @PathVariable Long id) {
    model.addAttribute("publisher", publisherService.findById(id));
    return "publisher/edit";
  }

  @PostMapping("/publisher/edit/{id}")
  public String processUpdatePublisherForm(Publisher publisher) {
    publisherService.update(publisher);
    return "redirect:/publishers";
  }

  @RequestMapping("/publisher/delete/{id}")
  public String deletePublisher(@PathVariable Long id) {
    try {
      publisherService.deleteById(id);
    } catch (JpaSystemException e){
      e.printStackTrace();
      return "publisher/error";
    }
    return "redirect:/publishers";
  }
}
