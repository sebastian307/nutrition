package pro.haug.nutrition.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.haug.nutrition.models.EntitySizeType;
import pro.haug.nutrition.models.Food;
import pro.haug.nutrition.repositories.EntityRepository;
import pro.haug.nutrition.repositories.FoodRepository;

import java.util.List;

@Controller
@RequestMapping(path="/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private EntityRepository entityRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewFood (@RequestParam String name
            , @RequestParam String sizeType) {


        List<EntitySizeType> sizeTypes = entityRepository.findByEntitySizeType(sizeType);
        if (sizeTypes.size()>0){
            Food newFood = new Food();
            newFood.setName(name);
            newFood.setEntitySizeType(sizeTypes.get(0));
            foodRepository.save(newFood);
            return "Saved";
        }

        return "Error";
    }

    @PostMapping(path="/delete")
    public @ResponseBody int deleteById (@RequestBody int id) {
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return Response.SC_ACCEPTED;
        }
        return Response.SC_BAD_REQUEST;
    }


    @PostMapping(path="/search")
    public @ResponseBody Iterable<Food> findByName (@RequestParam String name) {
        return foodRepository.findByNameContaining(name);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @GetMapping(path="/sizeOptions/all")
    public @ResponseBody Iterable<EntitySizeType> getAllSizeOptions() {
        return entityRepository.findAll();
    }

    @PostMapping(path="/sizeOptions/add")
    public @ResponseBody EntitySizeType addSizeOption(@RequestParam String sizeType) {
        EntitySizeType newEntitySizeType = new EntitySizeType();
        newEntitySizeType.setEntitySizeType(sizeType);
        return entityRepository.save(newEntitySizeType);
    }
}