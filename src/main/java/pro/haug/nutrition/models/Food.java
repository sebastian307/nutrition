package pro.haug.nutrition.models;

import pro.haug.nutrition.repositories.EntityRepository;

import javax.persistence.*;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToOne
    private EntitySizeType entitySizeType;

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

    public EntitySizeType getEntitySizeType() {
        return entitySizeType;
    }

    public void setEntitySizeType(EntitySizeType entitySizeType) {
        this.entitySizeType = entitySizeType;
    }

    //Excluded because unnecessary
    //@OneToMany(mappedBy = "food")
    //private List<RecipeIngredients> recipeAssoc;
}
