package weather.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import weather.weather.model.Weather;
import weather.weather.repository.CityRepository;
import weather.weather.repository.WeatherRepository;

@RestController
public class WeatherRestController {

    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    CityRepository cityRepository;

    // returning json for all weathers of city
    @GetMapping("/cities/{name}/all")
    public Iterable<Weather> getAllWeather(@PathVariable String name){
        if(cityRepository.existsByName(name)==true){
        return weatherRepository.findByCityName(name);}
        else return null;
    }
}
