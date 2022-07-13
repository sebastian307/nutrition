package pro.haug.nutrition.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class StoredMeals {
    @Id
    private int id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;
    private BigDecimal assignedPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public BigDecimal getAssignedPrice() {
        return assignedPrice;
    }

    public void setAssignedPrice(BigDecimal assignedPrice) {
        this.assignedPrice = assignedPrice;
    }
}
