package com.challenge.weather.search.validator;

import com.challenge.weather.search.model.City;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CityValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return City.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "name", "city.name.empty");
    City cit = (City) target;
    if (cit.getName().equalsIgnoreCase("London") || cit.getName().equalsIgnoreCase("Hong Kong")) {
      errors.rejectValue("name", "city.name.invalid");
    }


  }

}
