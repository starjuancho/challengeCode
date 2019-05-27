package com.challenge.weather.search.formatter;

import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.util.Utility;
import com.challenge.weather.search.view.CityWeather;

import java.time.LocalDate;

/**
 * Formatter class.
 * 
 * @author Erick Garcia
 *
 */
public class OpenWeatherFormatter {

  private OpenWeatherFormatter() {}

  /**
   * Method to convert from CurrentWeather to CityWeather type.
   * 
   * @param currentWeather object.
   * @return CityWeather object.
   */
  public static CityWeather convertToCityWeather(CurrentWeather currentWeather) {


    CityWeather cw = new CityWeather();
    cw.setCity(currentWeather.getName());
    LocalDate date = LocalDate.now();
    cw.setDate(date);
    cw.setDescription(currentWeather.getWeather().get(0).getDescription());
    cw.setTemperatureF(Utility.convertKelvinToFahr(currentWeather.getMain().getTemp()));
    cw.setTemperatureC(Utility.convertKelvinToCelsius(currentWeather.getMain().getTemp()));
    cw.setSunriseTime(Utility.convertTimeStampToLocalTime(currentWeather.getSys().getSunrise(),
        currentWeather.getTimezone()));
    cw.setSunsetTime(Utility.convertTimeStampToLocalTime(currentWeather.getSys().getSunset(),
        currentWeather.getTimezone()));

    return cw;

  }

}
