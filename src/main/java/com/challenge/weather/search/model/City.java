package com.challenge.weather.search.model;

import javax.validation.constraints.NotBlank;
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

  @NotBlank
  private String name;

}
