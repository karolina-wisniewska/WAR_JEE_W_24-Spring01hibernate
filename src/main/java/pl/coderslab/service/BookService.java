package pl.coderslab.service;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookService {

    void save(Book book);

    Book findById(Long id);

    List<Book> findAll();

    List<Book> findAllByRating(int rating);

    List<Book> findByPublisherIsNotNull();

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    Book findTopByCategoryIdOrderByTitleAsc(Long id);
    List<Book> findByCategoryId(Long id);
    List<Book> findByRating(int rating);

    List<Book> findByAuthor(Author author);

    void update(Book book);

    void deleteById(Long id);
}