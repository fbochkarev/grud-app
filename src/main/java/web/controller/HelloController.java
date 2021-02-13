package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    CarService carService = new CarServiceImpl();

    @GetMapping(value = "/hello")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @RequestMapping(value="/cars", method = RequestMethod.GET)
    public String getCar(ModelMap model,
                          @RequestParam(value = "count", required = false) Integer count){

        if (count == null) {
            model.addAttribute("cars", carService.findAll());
        } else {
            model.addAttribute("cars", carService.findCarByCount(count));
        }

        return "cars";
    }

}