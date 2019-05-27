package com.challenge.weather.search.client.model;

import java.util.List;
import lombok.Data;

@Data
public class CurrentWeather {

  private Coord coord;

  private List<Weather> weather;

  private String base;

  private MainInfo main;

  private Double visibility;

  private Wind wind;

  private Sys sys;

  private String name;

  private Long timezone;

}
