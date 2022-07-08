package pro.haug.nutrition.repositories;
import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.Food;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Integer>{
    Iterable<Food> findByNameContaining(String name);
}
