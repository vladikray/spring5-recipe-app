package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;
  private Integer prepareTime;
  private Integer cookTime;
  private Integer servins;
  private String source;
  private String url;

  @Lob
  private String directions;

  @Lob
  private Byte[] image;

  @OneToOne(cascade = CascadeType.ALL)
  private Notes notes;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
  private Set<Ingredient> ingredients = new HashSet<>();

  @Enumerated(value = EnumType.STRING)
  private Difficulty difficulty;

  @ManyToMany
  @JoinTable(name = "recipe_categories",
    joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Category> categories = new HashSet<>();


  public void setNotes(Notes notes) {
    notes.setRecipe(this);
    this.notes = notes;
  }

  public Recipe addIngredient(Ingredient ingredient) {
    ingredient.setRecipe(this);
    this.ingredients.add(ingredient);
    return this;
  }



}
