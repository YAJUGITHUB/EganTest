package com.egen.test;

import java.util.Calendar;
import java.util.Date;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.egan.test.repository.MetricesRepositoryImpl;
import com.egan.test.rule.OverWeightRule;
import com.egan.test.rule.UnderWeightRule;
import com.egan.test.service.AlertService;
import com.egan.test.vo.AllDetails;
import com.egan.test.vo.MetricesDetails;
import com.egan.test.vo.PersonDetails;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.egan.test")
public class Application {
	public static void main(String[] args) {		
		ApplicationContext ctx = SpringApplication.run(Application.class);
		

		AllDetails detail = new AllDetails();
		detail.setId(1231233);
		detail.setName("Yajuvendra Singh");
		detail.setAge(39);
		detail.setWeight(120.5);
		detail.setTime(new Date());
		detail.setBaseWeight(135.0);
		MetricesRepositoryImpl repository = ctx.getBean(MetricesRepositoryImpl.class);
		repository.create(detail);		
		RulesEngine rulesEngine =  RulesEngineBuilder.aNewRulesEngine().build();
		AlertService alertService = (AlertService)ctx.getBean(AlertService.class);
		Date startDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DAY_OF_MONTH,-1);
		alertService.readByTimeRange(cal.getTime(), new Date());
		rulesEngine.registerRule(new OverWeightRule(detail,alertService));
		rulesEngine.registerRule(new UnderWeightRule(detail,alertService));
		rulesEngine.fireRules();
		for (PersonDetails personDetails : repository.read()) {
			System.out.println(personDetails.getPersonId());
			for (MetricesDetails metricesDetail : personDetails.getMetricesDetail()) {
				System.out.println(metricesDetail);
			}
		}
	}
}