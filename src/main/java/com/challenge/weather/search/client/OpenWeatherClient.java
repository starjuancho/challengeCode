package com.challenge.weather.search.client;

import com.challenge.weather.search.client.model.CurrentWeather;

public interface OpenWeatherClient {


  public CurrentWeather getWeather(String city);

}
