package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(exclude = "recipe")
@Data
@Entity
public class Notes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @OneToOne
  Recipe recipe;

  @Lob
  String recipeNotes;

}
