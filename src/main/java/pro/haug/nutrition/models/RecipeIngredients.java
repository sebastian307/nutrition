package pro.haug.nutrition.models;

import javax.persistence.*;

@Entity
public class RecipeIngredients {
    @EmbeddedId
    private RecipeIngredientsId id = new RecipeIngredientsId();

    @ManyToOne
    @MapsId("recipeId")
    private Recipe recipe;

    @ManyToOne
    @MapsId("foodId")
    private Food food;

    @Column(name = "entityCount")
    private int entityCount;
}
