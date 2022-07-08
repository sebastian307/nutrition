package pro.haug.nutrition.models;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EntitySizeTypes entitySizeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntitySizeTypes getEntitySizeType() {
        return entitySizeType;
    }

    public void setEntitySizeType(EntitySizeTypes entitySizeType) {
        this.entitySizeType = entitySizeType;
    }

    //Excluded because unnecessary
    //@OneToMany(mappedBy = "food")
    //private List<RecipeIngredients> recipeAssoc;
}
