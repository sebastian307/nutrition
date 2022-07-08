package pro.haug.nutrition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.haug.nutrition.models.EntitySizeTypes;
import pro.haug.nutrition.models.Food;
import pro.haug.nutrition.repositories.FoodRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/food")
public class FoodController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private FoodRepository foodRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewFood (@RequestParam String name
            , @RequestParam EntitySizeTypes sizeType) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Food newFood = new Food();
        newFood.setName(name);
        newFood.setEntitySizeType(sizeType);
        foodRepository.save(newFood);
        return "Saved";
    }

    @PostMapping(path="/search")
    public @ResponseBody Iterable<Food> findByName (@RequestParam String name) {
        return foodRepository.findByNameContaining(name);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Food> getAllUsers() {
        // This returns a JSON or XML with the users
        return foodRepository.findAll();
    }
}