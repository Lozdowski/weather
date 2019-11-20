package weather.weather.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TemperatureModel {

    @JsonProperty("temp")
    private double temperature;
    @JsonProperty("pressure")
    private double pressure;
}
