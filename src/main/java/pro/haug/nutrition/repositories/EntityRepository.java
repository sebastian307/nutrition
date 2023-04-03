package pro.haug.nutrition.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.EntitySizeType;

import java.util.List;

public interface EntityRepository extends CrudRepository<EntitySizeType, Integer> {
    List<EntitySizeType> findByName(String name);
}
