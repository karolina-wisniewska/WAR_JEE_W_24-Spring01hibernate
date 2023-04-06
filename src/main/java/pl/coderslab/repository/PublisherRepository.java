package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Category;

public interface PublisherRepository extends JpaRepository<Category, Long> {

  

}
