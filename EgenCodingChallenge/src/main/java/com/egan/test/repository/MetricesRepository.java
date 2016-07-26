package com.egan.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.egan.test.vo.AllDetails;
import com.egan.test.vo.MetricesDetails;
import com.egan.test.vo.PersonDetails;

@Repository
public interface MetricesRepository {
public void create(AllDetails allDetails);
public List<PersonDetails> read();
public List<MetricesDetails> readByTimeRange(Date startDate, Date endDate);
}
