package pro.haug.nutrition.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EntitySizeType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String entitySizeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntitySizeType() {
        return entitySizeType;
    }

    public void setEntitySizeType(String entitySizeType) {
        this.entitySizeType = entitySizeType;
    }
}
