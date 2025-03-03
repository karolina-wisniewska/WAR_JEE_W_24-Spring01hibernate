package pl.coderslab.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@ToString(exclude = "books")
@Setter
@Getter
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String name;
  @NIP
  private String nip;
  @REGON
  private String regon;

  @OneToMany(mappedBy = "publisher")
  @Setter(AccessLevel.NONE)
  @Getter(AccessLevel.NONE)
  private List<Book> books = new ArrayList<>();
}