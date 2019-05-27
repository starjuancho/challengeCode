package com.challenge.weather.search.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import com.challenge.weather.search.client.OpenWeatherClient;
import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.client.model.MainInfo;
import com.challenge.weather.search.client.model.Sys;
import com.challenge.weather.search.client.model.Weather;
import com.challenge.weather.search.constants.ConstantsTests;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class WeatherSearchServiceImplTest {


  @Mock
  OpenWeatherClient openWeatherClient;

  @InjectMocks
  WeatherSearchServiceImpl weatherSearchServiceImpl;

  CurrentWeather currentWeather;

  @Before
  public void setUp() {

    currentWeather = new CurrentWeather();
    List<Weather> weather = new ArrayList<>();
    Weather e = new Weather();
    String description = "";
    e.setDescription(description);
    weather.add(e);
    currentWeather.setWeather(weather);
    MainInfo main = new MainInfo();
    Double temp = Double.valueOf(273.15);
    main.setTemp(temp);
    currentWeather.setMain(main);
    Sys sys = new Sys();
    sys.setSunrise(Long.valueOf(1558954865));
    sys.setSunset(Long.valueOf(1558954865));
    currentWeather.setSys(sys);
    currentWeather.setTimezone(Long.valueOf(28800));


  }

  @Test
  public void getWeatherInfoTest() {


    Mockito.when(openWeatherClient.getWeather((Mockito.anyString()))).thenReturn(currentWeather);

    weatherSearchServiceImpl.getWeatherInfo(ConstantsTests.CITY);
  }

}
