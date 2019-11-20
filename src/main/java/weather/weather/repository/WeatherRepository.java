package weather.weather.repository;

import org.springframework.data.repository.CrudRepository;
import weather.weather.model.Weather;

import java.util.List;

public interface WeatherRepository extends CrudRepository<Weather,Integer> {
    public List<Weather> findByCityName(String name);


    /* find by city name --- hibernate sql
    !Query(value = "SELECT w FROM Weather w WHERE w.city.name=?1")
    public List<Weather> findByCityName(String name);
     */





}
