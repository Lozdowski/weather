package weather.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class City {



    public City(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    //mapped to nazwa pola z weather
    // additional
    @OneToMany(mappedBy = "city")
    List<Weather> weathers = new ArrayList<>();
}
