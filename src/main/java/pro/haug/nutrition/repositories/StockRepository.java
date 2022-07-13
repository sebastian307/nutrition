package pro.haug.nutrition.repositories;
import org.springframework.data.repository.CrudRepository;
import pro.haug.nutrition.models.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer>{
    Iterable<Stock> findByFoodNameContaining(String name);
}
