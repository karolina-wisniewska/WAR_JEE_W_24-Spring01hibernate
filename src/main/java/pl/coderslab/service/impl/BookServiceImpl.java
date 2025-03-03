package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public BookServiceImpl(BookDao bookDao, PublisherService publisherService, AuthorService authorService) {
        this.bookDao = bookDao;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book findById(Long id) {
        Book book = bookDao.findById(id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findAllByRating(int rating) {
        return bookDao.findByRating(rating);
    }

    @Override
    public List<Book> findByPublisherIsNotNull() {
        return bookDao.findByPublisherIsNotNull();
    }

    @Override
    public List<Book> findByPublisher(Publisher publisher) {
        return bookDao.findByPublisher(publisher);
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        return bookDao.findByAuthor(author);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findByCategory(Category category) {
        return null;
    }

    @Override
    public Book findTopByCategoryIdOrderByTitleAsc(Long id) {
        return null;
    }

    @Override
    public List<Book> findByCategoryId(Long id) {
        return null;
    }

    @Override
    public List<Book> findByRating(int rating) {
        return null;
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void deleteById(Long id) {
        bookDao.deleteById(id);
    }


}
