package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @GetMapping(path = "/book/form")
    String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping(path = "/book/form")
    String processAddBookForm(@Valid Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book/add";
        }
        bookService.save(book);
        return "redirect:/book/list";
    }

    @GetMapping(path = "/book/edit")
    String showEditBookForm(Model model, @RequestParam Long id) {
        model.addAttribute("book", bookService.findById(id));
        return "book/edit";
    }

    @PostMapping(path = "/book/edit")
    String processEditBookForm(@Valid Book book, BindingResult result) {
        if(result.hasErrors()){
            return "book/edit";
        }
        bookService.update(book);
        return "redirect:/book/list";
    }

    @GetMapping(path = "/book/list")
    String showBookList(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping(path = "book/search", params = "title")
    String findByTitle(@RequestParam String title, Model model){
        List<Book>  books = bookService.findByTitle(title);
        model.addAttribute("books", books);
        return "book/list";
    }

//    @GetMapping(path = "book/search", params = "id")
//    String findByCategory(Category category, Model model){
//        List<Book> books = bookService.findByCategory(category);
//        model.addAttribute("books", books);
//        return "book/list";
//    }

    @GetMapping(path = "book/search", params = "id")
    String findFirstByCategoryOrderByTitleAsc(@RequestParam Long id, Model model) {
        Book book = bookService.findTopByCategoryIdOrderByTitleAsc(id);
        model.addAttribute("book", book);
        return "book/one";
    }

    @GetMapping(path = "book/search", params = "categoryId")
    String findByCategoryId(@RequestParam Long categoryId, Model model){
        List<Book> books = bookService.findByCategoryId(categoryId);
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping(path = "book/search", params = "rating")
    String findByRating(@RequestParam int rating, Model model){
        List<Book>  books = bookService.findByRating(rating);
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping(path = "book/search", params = "authorId")
    String findByAuthor(@RequestParam Long authorId, Model model){
        Author author = authorService.findById(authorId);
        List<Book> books = bookService.findByAuthor(author);
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping(path = "book/search", params = "publisherId")
    String findByPublisher(@RequestParam Long publisherId, Model model){
        Publisher publisher = publisherService.findById(publisherId);
        List<Book> books = bookService.findByPublisher(publisher);
        model.addAttribute("books", books);
        return "book/list";
    }

    @ModelAttribute("publishers")
    List<Publisher> publishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    List<Author> authors() {
        return authorService.findAll();
    }

    @ModelAttribute("categories")
    List<Category> categories() {
        return categoryService.findAll();
    }
}
