package pro.haug.nutrition.repositories;
import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.StoredMeals;

public interface StoredMealsRepository extends CrudRepository<StoredMeals, Integer>{
}
