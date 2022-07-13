package pro.haug.nutrition.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecipeIngredientsId implements Serializable {
    private int recipeId;
    private int foodId;

    public boolean equals(Object object) {
        if (object instanceof RecipeIngredientsId) {
            RecipeIngredientsId otherId = (RecipeIngredientsId) object;
            return (otherId.recipeId == this.recipeId)
                    && (otherId.foodId == this.foodId);
        }
        return false;
    }
    public int hashCode() {
        return (int)(recipeId + foodId);
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

}
