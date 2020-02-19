package by.sTm.t2.controller;

import by.sTm.t2.domain.Car;
import by.sTm.t2.service.BasketService;
import by.sTm.t2.service.CarService;
import by.sTm.t2.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasketController {
    @Autowired
    private BasketService basketService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CarService carService;

    @GetMapping(value = "/t2/basket")
    public String carList(Model model){
        model.addAttribute("listBasket", basketService.getList());
        return "basket";
    }

    //--Покупка
    @PostMapping(value = "/buy")
    public String buyCar(Model model, @RequestParam("car") int id, @RequestBody String reqBody){
        Car car = basketService.getById(id);
        basketService.deleteById(id);
        historyService.add(car);
        model.addAttribute("listBasket", basketService.getList());
        return "basket";
    }

    //--Отмена покупки
    @PostMapping(value = "/del")
    public String delCar(Model model, @RequestParam("car_del") int id){
        Car car = basketService.getById(id);
        basketService.deleteById(id);
        carService.add(car);
        model.addAttribute("listBasket", basketService.getList());
        return "basket";
    }
}
