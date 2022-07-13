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

    public RecipeIngredientsId getId() {
        return id;
    }

    public void setId(RecipeIngredientsId id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getEntityCount() {
        return entityCount;
    }

    public void setEntityCount(int entityCount) {
        this.entityCount = entityCount;
    }
}
