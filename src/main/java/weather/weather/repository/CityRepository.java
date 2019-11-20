package weather.weather.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import weather.weather.model.City;

import java.util.Optional;

public interface CityRepository extends CrudRepository<City,Integer> {

    // 1 automagia, ta metoda musi sie tak nazywac
    Optional<City> findByName(String name);
  //   2 czysty sql ?1 paramentr podstaw z metody
    @Query(value = "SELECT * FROM city  WHERE c.name=?1 LIMIT 1",nativeQuery = true)
    City findByCityName(String name);

    boolean existsByName(String name);

//    // hibernate sql ?1 paramentr podstaw z metody
//    @Query("select c from City c where c.name=?1")
//    City findByCity(String name);

}
