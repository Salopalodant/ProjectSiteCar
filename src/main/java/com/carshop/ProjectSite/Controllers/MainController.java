package com.carshop.ProjectSite.Controllers;

import lombok.RequiredArgsConstructor;
import com.carshop.ProjectSite.Models.Car;
import com.carshop.ProjectSite.Service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class MainController {
    @Autowired
    private ICarService RatesService;

    public MainController(ICarService ratesService) {
        RatesService = ratesService;
    }

    @GetMapping("/ServiceRatesPage")
    public String ServicePage(Model model, Car rate) {
        model.addAttribute("Rates", RatesService.listRates());
        RatesService.updateRate(rate);
        return "ServiceRatesPage";
    }

    @PostMapping("ServiceRatesPage/create")
    public String createTracking(Car rate) {
        RatesService.saveRate(rate);
        return "redirect:/ServiceRatesPage";
    }
    @PostMapping("ServiceRatesPage/delete/{id}")
    public String deleteTracking(@PathVariable int id, Car rate){
        RatesService.deleteRate(id);
        return "redirect:/ServiceRatesPage";
    }
    @PostMapping("ServiceRatesPage/sell/{id}")
    public String sellCar(@PathVariable int id) {
        Car car = RatesService.getRateById(id);
        if (car.getIsSold().equals("Да")) {
            car.setIsSold("Нет");
        } else {
            car.setIsSold("Да");
        }
        RatesService.updateRate(car);
        return "redirect:/ServiceRatesPage";
    }

    @GetMapping("/ServiceRatesPage/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        Car car = RatesService.getRateById(id);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PutMapping("/ServiceRatesPage/update/{id}")
    public String updateCar(@PathVariable int id, Car car) {
        car.setId(id);
        RatesService.updateRate(car);
        return "redirect:/ServiceRatesPage";
    }

}
