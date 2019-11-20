package weather.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import weather.weather.model.City;
import weather.weather.model.Weather;
import weather.weather.repository.CityRepository;
import weather.weather.repository.WeatherRepository;
import weather.weather.service.WeatherModel;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    CityRepository cityRepository;

    @GetMapping("/weather")
    public String index(@RequestParam String city, ModelMap map){
        WeatherModel weatherModel = new RestTemplate().getForObject(
                "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=ef2028e98b54649bf1f4c4582631f350&units=metric",
                WeatherModel.class);
        map.put("city",city);
        map.put("weather",weatherModel);
        Weather weather = new Weather();
        City myCity = cityRepository.findByName(city).orElse(new City(city));
        cityRepository.save(myCity);
        weather.setCity(myCity);
        weather.setTemperature(weatherModel.getTemperatureModel().getTemperature());
        weather.setPressure(weatherModel.getTemperatureModel().getPressure());
        weather.setDate(LocalDate.now());
        weatherRepository.save(weather);
        return "result";
    }
    @RequestMapping("/cities/{name}")
    public String getAllWeathers(@PathVariable String name, ModelMap map){
        map.put("name",name);
        map.put("weathers",weatherRepository.findByCityName(name));
        //alternatywnie map.put("weathers",cityRepository.findByName(name).get().getWeathers());
        return "all";
    }
}