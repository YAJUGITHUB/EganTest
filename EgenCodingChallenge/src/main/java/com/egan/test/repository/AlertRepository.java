package com.egan.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.egan.test.vo.AlertDetails;

@Repository
public interface AlertRepository {
public List<AlertDetails> read();
public List<AlertDetails> readByTimeRange(Date startDate, Date endDate);
public void create(AlertDetails alertDetails);
}
