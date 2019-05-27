package com.challenge.weather.search.controller;

import com.challenge.weather.search.constants.Constants;
import com.challenge.weather.search.service.WeatherSearchService;
import com.challenge.weather.search.view.City;
import com.challenge.weather.search.view.CityWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * WeatherSearchController to manage the request from the static content.
 * 
 * @author Erick Garcia
 *
 */
@Controller
public class WeatherSearchController {

  /**
   * Injected dependency to search the weather information.
   */
  @Autowired
  WeatherSearchService weatherSearchService;

  /**
   * entry point to display the initial page.
   * 
   * @return ModwlAndView object.
   */
  @GetMapping("weather")
  public ModelAndView showForm() {

    ModelAndView mv = new ModelAndView();
    mv.addObject("city", new City());
    mv.setViewName(Constants.INITIAL_PAGE);
    return mv;
  }



  /**
   * Entry point launched when a weather search by city name is performed.
   * 
   * @param city of type City.
   * @param result of type BindingResult.
   * @param model of type ModelMap.
   * @return ModelAndView objet with the information requested.
   */
  @PostMapping("weather")
  public ModelAndView submit(@Valid @ModelAttribute("city") City city, BindingResult result,
      ModelMap model) {

    if (result.hasErrors()) {
      return new ModelAndView(Constants.INITIAL_PAGE);
    }
    model.addAttribute("name", city.getName());
    ModelAndView mv = new ModelAndView();
    CityWeather cw = weatherSearchService.getWeatherInfo(city.getName());
    mv.addObject("cityWeather", cw);
    mv.setViewName(Constants.INITIAL_PAGE);
    return mv;
  }

}
