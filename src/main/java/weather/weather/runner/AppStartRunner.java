package weather.weather.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import weather.weather.model.City;
import weather.weather.model.Weather;
import weather.weather.repository.CityRepository;
import weather.weather.repository.WeatherRepository;

import java.time.LocalDate;

@Component
public class AppStartRunner implements ApplicationRunner {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private WeatherRepository weatherRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(cityRepository.count()==0){
           cityRepository.save( new City("Wroclaw "));
           cityRepository.save(new City("Warsaw"));
        }
        City city = cityRepository.findById(1).get();
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setPressure(1005.33);
        weather.setTemperature(12.4);
        weather.setDate(LocalDate.now());
        weatherRepository.save(weather);

    }
}
