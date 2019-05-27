package com.challenge.weather.search.view;

import com.challenge.weather.search.validator.CityConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO model for City.
 * 
 * @author Erick Garcia
 *
 */
@Getter
@Setter
public class City {

  @CityConstraint
  private String name;

}
