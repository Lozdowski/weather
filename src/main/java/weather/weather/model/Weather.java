package weather.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.portable.IDLEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Weather {
    /*
        co zawiera pogoda ?
        kazde pole ma nazwe i typ

        w liczbie mnogiej -> collection
        mamy pola ze soba powiazane --> te pola trzeba rozbic do oddzielnej klasy
        2 pola powiazane - moze klasa moze nie
        3 pola powiazane - klasa
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double temperature;
    private Double pressure;
    //klucz obcy weather, city
    @OneToOne
    private City city;
    private LocalDate date;
}
