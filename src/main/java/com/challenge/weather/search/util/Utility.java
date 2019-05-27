package com.challenge.weather.search.util;

import com.challenge.weather.search.constants.Constants;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * Utility class for common or reusable methods.
 * 
 * @author Erick Garcia
 *
 */
public class Utility {

  private Utility() {

  }

  /**
   * Method to convert from Kelvin to Fahrenheit degrees.
   * 
   * @param temp of type Double
   * @return Double type reference.
   */
  public static Double convertKelvinToFahr(Double temp) {
    return Math.floor((((temp - 273.15) * 9 / 5) + 32) * 100) / 100;
  }

  /**
   * Method to convert from Kelvin to Celsius degrees.
   * 
   * @param temp of type Double
   * @return Double type reference.
   */
  public static Double convertKelvinToCelsius(Double temp) {
    return Math.floor((temp - 273.15) * 100) / 100;
  }

  /**
   * Method to convert a time in Long format to a LocalTime in String format.
   * 
   * @param time of type Long
   * @param zoneId of type Long
   * @return String reference.
   */
  public static String convertTimeStampToLocalTime(Long time, Long zoneId) {
    String pattern = Constants.TIME12HFORMAT;
    LocalDateTime ldt = getDateTimeFromTimestamp(time, zoneId);
    LocalTime lt = ldt.toLocalTime();
    return lt.format(DateTimeFormatter.ofPattern(pattern));

  }

  /**
   * Method to obtain convert a timestamp in long to a LocalDateTime reference.
   * 
   * @param timestamp of type Long
   * @param zoneId of type Long
   * @return LocalDateTime reference.
   */
  public static LocalDateTime getDateTimeFromTimestamp(Long timestamp, Long zoneId) {
    return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp + zoneId),
        TimeZone.getTimeZone(Constants.TIMEZONE).toZoneId());
  }
}


