package by.sTm.t2.controller;

import by.sTm.t2.domain.Car;
import by.sTm.t2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarCmpController {
    @Autowired
    private CarService carService;

    @Autowired
    private CarCmp carCmp;

    @GetMapping(value = "/SortById")
    public String sortById(Model model){
        carCmp.doCompare(carService.getList(), Car.COMPARE_BY_ID, false);
        model.addAttribute("listCar", carService.getList());
        return "index";
    }

    @GetMapping(value = "/SortByModel")
    public String sortByModel(Model model){
        carCmp.doCompare(carService.getList(), Car.COMPARE_BY_MODEL, false);
        model.addAttribute("listCar", carService.getList());
        return "index";
    }

    @GetMapping(value = "/SortByPrice")
    public String sortByPrice(Model model){
        carCmp.doCompare(carService.getList(), Car.COMPARE_BY_PRICE, false);
        model.addAttribute("listCar", carService.getList());
        return "index";
    }
}
