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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<RecipeIngredients> getRecipeAssoc() {
        return recipeAssoc;
    }

    public void setRecipeAssoc(List<RecipeIngredients> recipeAssoc) {
        this.recipeAssoc = recipeAssoc;
    }
}
