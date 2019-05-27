<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dli HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dli">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div>
<h2>Welcome to weather search</h2>
</div>


 <h3>Enter The city name</h3>
        <form:form method="POST"
          action="/weather" modelAttribute="city">
              <form:label path="name">Search Weather for: </form:label>
              <form:input path="name"/>
              <form:errors path="name" cssClass="error"/> 
              <br></br>
              <input type="submit" value="Submit"/>
          
        </form:form>
        
<label >The weather information is:</label>


  <ul style="list-style-type:none;">
    <li>City: 		${cityWeather.city}</li>
    <li>Date: 		  ${cityWeather.date}</li>
    <li>Description:  ${cityWeather.description}</li>
    <li>Temperature in °F:  ${cityWeather.temperatureF}</li>
    <li>Temperature in °C:  ${cityWeather.temperatureC}</li>
    <li>Sunrise time: ${cityWeather.sunriseTime}</li>
    <li>Sunset time:  ${cityWeather.sunsetTime}</li>
  </ul>
  
 


</body>
</html>
