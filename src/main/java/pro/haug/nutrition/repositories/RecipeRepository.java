package pro.haug.nutrition.repositories;
import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>{
}
