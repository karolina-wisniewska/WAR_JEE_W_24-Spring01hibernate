package pl.coderslab.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

  @Override
  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  List<Book> findAll();

  @Override
  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  Optional<Book> findById(Long id);

  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  @Query("select b from Book b where b.title = :title")
  List<Book> findByTitle(@Param("title") String title);

  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  @Query("select b from Book b where b.category = :category")
  List<Book> findByCategory(@Param("category") Category category);

  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  Book findTopByCategoryIdOrderByTitleAsc(Long id);
  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  List<Book> findByCategoryId(Long id);

  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  @Query("select b from Book b where b.rating = :rating")
  List<Book> findByRating(@Param("rating") int rating);

  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  @Query("select distinct b from Book b where :author member of b.authors")
  List<Book> findByAuthor(@Param("author")Author author);

  @EntityGraph(attributePaths = {"publisher", "authors", "category"})
  @Query("select b from Book b where b.publisher = :publisher")
  List<Book> findByPublisher(@Param("publisher") Publisher publisher);

}


