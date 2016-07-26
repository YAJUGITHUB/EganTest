package com.egen.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
public class AlertControllerTest extends AbstractTest{
	
	 @Autowired
     private WebApplicationContext ctx;

	 private MockMvc mockMvc;
	
	
    @Before
    public void setUp() {    	
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();   	
   }    
    
    @Test
    public void read() throws Exception {
    	 mockMvc.perform(MockMvcRequestBuilders.get("/alerts/read")).andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void readByTimeRange() throws Exception {
    	Date startDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		Date endDate = cal.getTime();
    	 mockMvc.perform(MockMvcRequestBuilders.get("/alerts/readByTimeRange")
    			 .param("startDate", startDate.toString())
		 		 .param("endDate", endDate.toString()))
    	 		 .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
