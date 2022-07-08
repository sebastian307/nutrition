package pro.haug.nutrition.repositories;
import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.RecipeIngredients;

public interface RecipeIngredientsRepository extends CrudRepository<RecipeIngredients, Integer>{
}
