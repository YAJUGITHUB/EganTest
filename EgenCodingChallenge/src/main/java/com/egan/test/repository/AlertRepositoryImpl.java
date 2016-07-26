package com.egan.test.repository;

import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import com.egan.test.mongodb.connection.MongoDBConnection;
import com.egan.test.vo.AlertDetails;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

	private AlertDetails read(double id) {
		// TODO Auto-generated method stub
		AlertDetails alertDetails = (AlertDetails) MongoDBConnection.getConnection().createQuery(AlertDetails.class).filter("id =", id);
		
		return alertDetails;
	}
	
	@Override
	public List<AlertDetails> read(){
		List<AlertDetails> alertDetails = (List<AlertDetails>) MongoDBConnection.getConnection().createQuery(AlertDetails.class).asList();
		
		return alertDetails;
	}
	
	private List<AlertDetails> getAlertDetails(double id){
		final Query<AlertDetails> query =  MongoDBConnection.getConnection().createQuery(AlertDetails.class).filter("id =",id);
		List<AlertDetails> alertDeatsil = query.asList();		 
		return alertDeatsil;
}
	
	@Override
	public List<AlertDetails> readByTimeRange(Date startDate, Date endDate) {		
		final Query<AlertDetails> query =  MongoDBConnection.getConnection().createQuery(AlertDetails.class).filter("time >=",startDate).filter("time <=", endDate);
		List<AlertDetails> metricesDetails = query.asList();		 
		return metricesDetails;	
	}
	@Override
	public void create(AlertDetails alertDeatsil) {
		Datastore dataStore = MongoDBConnection.getConnection();					
			dataStore.save(alertDeatsil);			
	}
}
