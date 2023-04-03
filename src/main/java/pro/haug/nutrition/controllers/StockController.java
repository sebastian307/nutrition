package pro.haug.nutrition.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro.haug.nutrition.models.Food;
import pro.haug.nutrition.models.Stock;
import pro.haug.nutrition.repositories.FoodRepository;
import pro.haug.nutrition.repositories.StockRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/stock")
public class StockController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private StockRepository stockRepository;
    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addStockByFood (@RequestBody Stock stock) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        stockRepository.save(stock);
        return "Saved";
    }

    @PostMapping(path="/addByFoodId")
    public @ResponseBody String addStockByFoodId (@RequestParam int foodId, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, @RequestParam double entity_count, @RequestParam String comments, BigDecimal price) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        //Check if food with corresponding Id exists
        Optional<Food> food = foodRepository.findById(foodId);
        if (food.isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Food Not Found");
        }

        Stock newStock = new Stock();
        newStock.setFood(food.get());
        newStock.setBestBeforeDate(date);
        newStock.setEntity_count(entity_count);
        newStock.setComments(comments);
        newStock.setPrice(price);
        stockRepository.save(newStock);
        return "Saved";
    }

    @PostMapping(path="/search")
    public @ResponseBody Iterable<Stock> findByFoodName (@RequestParam String name) {
        return stockRepository.findByFoodNameContaining(name);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}