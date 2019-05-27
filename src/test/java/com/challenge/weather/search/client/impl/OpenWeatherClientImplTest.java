package com.challenge.weather.search.client.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import com.challenge.weather.search.client.model.CurrentWeather;

@RunWith(SpringRunner.class)
public class OpenWeatherClientImplTest {

  @Mock
  RestTemplate restTemplate;

  @InjectMocks
  private OpenWeatherClientImpl empService = new OpenWeatherClientImpl();

  private CurrentWeather cw;

  @Before
  public void setUp() {

    cw = new CurrentWeather();

  }

  @Test
  public void testRestCall() {

    Mockito.when(restTemplate.getForEntity(
        "https://api.openweathermap.org/data/2.5/weather?q=London&APPID=6439103f2055efe2d2159bd06c670f5b",
        CurrentWeather.class)).thenReturn(new ResponseEntity<CurrentWeather>(cw, HttpStatus.OK));

    String city = "London";
    empService.getWeather(city);



  }

}
