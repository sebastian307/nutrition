package pro.haug.nutrition.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.haug.nutrition.models.Food;
import pro.haug.nutrition.models.Stock;
import pro.haug.nutrition.repositories.FoodRepository;
import pro.haug.nutrition.repositories.StockRepository;

import java.util.List;
import java.util.Map;

@Service
public class recipeService {
    @Autowired
    StockRepository recipeRepository;
    @Autowired
    FoodRepository foodRepository;

    public void addRecipe(String title, String comments, List<Map<Food, Integer>> ingredients){
    }
}
