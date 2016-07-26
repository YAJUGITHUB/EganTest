package com.egan.test.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.egan.test.service.MetricesService;
import com.egan.test.vo.AllDetails;
import com.egan.test.vo.MetricesDetails;
import com.egan.test.vo.PersonDetails;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.egan.test.vo.AllDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping("/metrices")
public class MetricesDetailController {
    private MetricesService metricesservice;

    @Autowired 
    public MetricesDetailController(final MetricesService metricesservice) {
        this.metricesservice = metricesservice;
    }
    
    @RequestMapping(value="/read",method = RequestMethod.GET)
    public List<PersonDetails> read() {
        List<PersonDetails> detail = metricesservice.read();
        if (detail == null) {
            throw new MetricesNotFoundException();
        } else {
            return detail;
        }
    }
    
    @RequestMapping(value="/readByTimeRange",method = RequestMethod.GET)
    public List<MetricesDetails> readByTimeRange(@RequestParam("startDate") Date startDate,@RequestParam("endDate") Date endDate) {
        List<MetricesDetails> detail = metricesservice.readByTimeRange(startDate,endDate);
        if (detail == null) {
            throw new MetricesNotFoundException();
        } else {
            return detail;
        }
    }
    
    @RequestMapping(value="/create", method = RequestMethod.POST,consumes = {MediaType.ALL_VALUE})
    public void create(@RequestParam("metricesJson")  String metricesJson)
    		throws JsonMappingException, JsonParseException, IOException {
        metricesservice.create(JsonToJave(metricesJson));
        
    }
    
    private AllDetails JsonToJave(String jsonObject){
    	Gson gson = new Gson();
		Type type = new TypeToken<AllDetails>() {}.getType();		
	    AllDetails allDetails = gson.fromJson(jsonObject, type);
	    return allDetails;
    }
     
    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class MetricesNotFoundException extends RuntimeException {
    }
}