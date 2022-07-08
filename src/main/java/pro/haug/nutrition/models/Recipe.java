package pro.haug.nutrition.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    private String comments;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredients> recipeAssoc;
}
