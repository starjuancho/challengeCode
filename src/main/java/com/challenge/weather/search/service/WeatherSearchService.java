package com.challenge.weather.search.service;

import com.challenge.weather.search.view.CityWeather;

/**
 * WeatherSearchService.
 * 
 * @author Erick
 *
 */
public interface WeatherSearchService {

  public CityWeather getWeatherInfo(String city);

}
