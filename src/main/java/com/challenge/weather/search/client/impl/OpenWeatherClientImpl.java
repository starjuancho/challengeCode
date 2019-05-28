package com.challenge.weather.search.client.impl;

import com.challenge.weather.search.client.OpenWeatherClient;
import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;


/**
 * Class that implements OpenWeatherClient interface.
 * 
 * @author Erick
 *
 */
@Service
public class OpenWeatherClientImpl implements OpenWeatherClient {


  private static final Logger log = LoggerFactory.getLogger(OpenWeatherClientImpl.class);

  /**
   * RestTemplate attribute to perform calls to OpenWeatherAPI.
   */
  RestTemplate restTemplate;



  /**
   * Method that performs the call to OpenWeatherAPI.
   */
  @Override
  public CurrentWeather getWeather(String city) {

    restTemplate = new RestTemplate();
    URI expanded = new UriTemplate(Constants.URI).expand(city, Constants.APPID);
    String url;
    try {
      url = URLDecoder.decode(expanded.toString(), Constants.UTF8EN);
      ResponseEntity<CurrentWeather> cw = restTemplate.getForEntity(url, CurrentWeather.class);
      if (cw.getBody() != null) {
        String response = "Open Weather Response:" + cw.getBody().toString();
        log.info(response);
        return cw.getBody();
      }
    } catch (UnsupportedEncodingException ex) {
      log.error(ex.getMessage());
    }
    return new CurrentWeather();
  }

}
