package com.challenge.weather.search.util;

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

  public static Double convertKelvinToFahr(Double temp) {
    return Math.floor((((temp - 273.15) * 9 / 5) + 32) * 100) / 100;
  }

  public static Double convertKelvinToCelsius(Double temp) {
    return Math.floor((temp - 273.15) * 100) / 100;
  }

  public static String convertTimeStampToLocalTime(Long time, Long zoneId) {
    String pattern = "hh:mm a";
    LocalDateTime ldt = getDateTimeFromTimestamp(time, zoneId);
    LocalTime lt = ldt.toLocalTime();
    return lt.format(DateTimeFormatter.ofPattern(pattern));

  }

  public static LocalDateTime getDateTimeFromTimestamp(Long timestamp, Long zoneId) {
    return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp + zoneId),
        TimeZone.getTimeZone("UTC").toZoneId());
  }
}


