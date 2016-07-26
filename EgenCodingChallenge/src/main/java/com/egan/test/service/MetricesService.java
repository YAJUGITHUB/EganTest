package com.egan.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egan.test.repository.MetricesRepository;
import com.egan.test.vo.AllDetails;
import com.egan.test.vo.MetricesDetails;
import com.egan.test.vo.PersonDetails;

@Service
public class MetricesService {
	@Autowired
	private MetricesRepository metricesRepository;
	
		
	public void create(AllDetails allDetails) {
		metricesRepository.create(allDetails);
	}

	
	public List<PersonDetails> read() {
		// TODO Auto-generated method stub
		return metricesRepository.read();
	}

	
	public List<MetricesDetails> readByTimeRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return metricesRepository.readByTimeRange(startDate,endDate);
	}
	
	
}
