package pro.haug.nutrition.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.EntitySizeType;
import pro.haug.nutrition.models.Food;

import java.util.List;

public interface EntityRepository extends CrudRepository<EntitySizeType, Integer> {
    List<EntitySizeType> findByEntitySizeType(String name);
}
