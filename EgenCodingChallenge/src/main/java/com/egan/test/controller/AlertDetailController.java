package com.egan.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.egan.test.service.AlertService;
import com.egan.test.vo.AlertDetails;



@RestController
@RequestMapping("/alerts")
public class AlertDetailController {
	@Autowired 
    private AlertService alertsservice;
     
    @RequestMapping(value="/read",method = RequestMethod.GET)
    public List<AlertDetails> read() {
        List<AlertDetails> detail = alertsservice.read();
        if (detail == null) {
            throw new AlertNotFoundException();
        } else {
            return detail;
        }
    }
    
    @RequestMapping(value="/readByTimeRange",method = RequestMethod.GET)
    public List<AlertDetails> readByTimeRange(@RequestParam("startDate") Date startDate,@RequestParam("endDate") Date endDate) {
        List<AlertDetails> detail = alertsservice.readByTimeRange(startDate,endDate);
        if (detail == null) {
            throw new AlertNotFoundException();
        } else {
            return detail;
        }
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class AlertNotFoundException extends RuntimeException {
    }
}