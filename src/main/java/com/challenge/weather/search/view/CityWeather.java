package com.challenge.weather.search.view;

import java.time.LocalDate;
import lombok.Data;

/**
 * POJO class used to show information in the static content.
 * 
 * @author Erick Garcia
 *
 */
@Data
public class CityWeather {

  LocalDate date;
  String city;
  String description;
  Double temperatureC;
  Double temperatureF;
  String sunriseTime;
  String sunsetTime;


}
