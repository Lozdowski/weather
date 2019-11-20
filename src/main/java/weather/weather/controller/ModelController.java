package weather.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import weather.weather.model.City;
import weather.weather.model.Weather;
import weather.weather.repository.CityRepository;
import weather.weather.repository.WeatherRepository;
import weather.weather.service.WeatherModel;

@Controller
public class ModelController {

    int a = 50;

    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping("/form")
    public String addCity(){

        return "form";
    }

}
