package com.egen.test;

import java.lang.reflect.Type;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.egan.test.vo.AllDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebAppConfiguration
public class MetricesControllerTest extends AbstractTest{
	@Autowired
    private WebApplicationContext ctx;

	private MockMvc mockMvc;
	
	
    @Before
    public void setUp() {    	
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();   	
   }    
    
  /*  @Test
    public void read() throws Exception {
    	 mockMvc.perform(MockMvcRequestBuilders.get("/metrices/read")).andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void readByTimeRange() throws Exception {
    	Date startDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		Date endDate = cal.getTime();
    	 mockMvc.perform(MockMvcRequestBuilders.get("/metrices/readByTimeRange")
    			 .param("startDate", startDate.toString())
		 		 .param("endDate", endDate.toString()))
    	 		 .andExpect(MockMvcResultMatchers.status().isOk());
    }*/
    
    @Test
    public void create() throws Exception {
    	AllDetails detail = new AllDetails();
		detail.setId(1231233);
		detail.setName("Person Name");
		detail.setAge(39);
		detail.setWeight(120.5);
		detail.setTime(new Date());
		detail.setBaseWeight(135.0);
		
    	Gson gson = new Gson();
		Type type = new TypeToken<AllDetails>() {}.getType();
		String json = gson.toJson(detail, type);
		System.out.println("Json " +json);
    	 mockMvc.perform(MockMvcRequestBuilders.post("/metrices/create")
    			 .param("metricesJson", json))		 		 
    	 		 .andExpect(MockMvcResultMatchers.status().isOk());
    }   

}
