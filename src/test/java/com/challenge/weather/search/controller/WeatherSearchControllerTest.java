package com.challenge.weather.search.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.challenge.weather.search.constants.ConstantsTests;
import com.challenge.weather.search.service.WeatherSearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/** 
 * Test class to test the functionality of the WeatherSearchController class.
 */
@RunWith(SpringRunner.class)
public class WeatherSearchControllerTest {
  
  /**
   * Injected controller to be tested with its inherent mocked dependencies.
   */
  @InjectMocks
  WeatherSearchController weatherSearchController;
  
  /**
   * Injected mocked dependency present in the WeatherSearchController class.
   */
  @MockBean
  WeatherSearchService weatherSearchService;
  
  /**
   * MockMvc reference needed to mock rest calls.
   */
  MockMvc mockMvc;
  
  /**
   * Initialization method.
   */
  @Before
  public void init() {
    
    
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/pages/");
    viewResolver.setSuffix(".jsp");

    mockMvc = MockMvcBuilders.standaloneSetup(weatherSearchController)
                             .setViewResolvers(viewResolver)
                             .build();
    MockitoAnnotations.initMocks(this);
    
  }
  
  
  /**
   * Test to simulate the call to the initial view page.
   * 
   * Given a well defined base path.
   * When the proper HTTP GET call is executed.
   * Then return value for the view that will be displayed.
   * @throws Exception reference.
   */
  @Test
  public void showFormTest() throws Exception{
      this.mockMvc.
        perform(get(ConstantsTests.BASE_PATH)).andExpect(view().name(ConstantsTests.INITIAL_VIEW));
  }

  
  /**
   * Test to simulate the sending form operation.
   * 
   * Given a well defined base path and a form with name property.
   * When the proper HTTP POST call is executed.
   * Then return value for the view that will be displayed.
   * @throws Exception reference.
   */
  @Test
  public void submitTest() throws Exception{
      this.mockMvc.
        perform(post(ConstantsTests.BASE_PATH)
        .accept(MediaType.TEXT_HTML)
        .param("name", "London"))

        .andExpect(view().name(ConstantsTests.INITIAL_VIEW))
        .andExpect(status().isOk())
        .andDo(print());
  }
  
  
  /**
   * Test to simulate the sending form operation with an 
   * invalid city name.
   * Given a well defined base path and a form with name property.
   * When the proper HTTP POST call is executed.
   * Then return value for the view that will be displayed 
   * and showing the constraint error.
   * @throws Exception reference.
   */
  @Test
  public void submitTestError() throws Exception{
      this.mockMvc.
        perform(post(ConstantsTests.BASE_PATH)
        .accept(MediaType.TEXT_HTML)
        .param("name", "Madrid"))
        .andExpect(model().attributeHasFieldErrorCode(
            "city","name","CityConstraint"))
        .andExpect(view().name(ConstantsTests.INITIAL_VIEW))
        .andExpect(status().isOk())
        .andDo(print());
  }
}


