package by.sTm.t2.controller;

import by.sTm.t2.domain.Car;
import by.sTm.t2.service.BasketService;
import by.sTm.t2.service.CarService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private BasketService basketService;

    @GetMapping(value = "/t2/index")
    public String carList(Model model){
        model.addAttribute("listCar", carService.getList());
        return "index";
    }

    @PostMapping(value = "/toBasket")
    public String addCarInStorage(@RequestParam("car") int id, Model model){
        Car car = carService.getById(id);
        carService.deleteById(id);
        basketService.add(car);
        List<Car> cars = carService.getList();
        model.addAttribute("listCar", cars);
        return "index";
    }
}
