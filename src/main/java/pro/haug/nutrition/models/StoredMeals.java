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
}
