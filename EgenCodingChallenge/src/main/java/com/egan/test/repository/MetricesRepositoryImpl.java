package com.egan.test.repository;

import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import com.egan.test.mongodb.connection.MongoDBConnection;
import com.egan.test.vo.AllDetails;
import com.egan.test.vo.MetricesDetails;
import com.egan.test.vo.PersonDetails;

@Repository
public class MetricesRepositoryImpl implements MetricesRepository {

	@Override
	public void create(AllDetails allDetails) {
		Datastore dataStore = MongoDBConnection.getConnection();
		if(!personExists(allDetails.getId())){
			final PersonDetails personDetails = new PersonDetails(allDetails.getId(),allDetails.getName(),allDetails.getAge());
			final MetricesDetails metricesDetail = new MetricesDetails(allDetails.getId(),allDetails.getWeight(),allDetails.getTime());			
			dataStore.save(personDetails);
			dataStore.save(metricesDetail);			
		}else{
			final MetricesDetails metricesDetail = new MetricesDetails(allDetails.getId(),allDetails.getWeight(),allDetails.getTime());
			dataStore.save(metricesDetail);
		}		
	}
	
	private PersonDetails read(double id) {
		// TODO Auto-generated method stub
		PersonDetails personalDetails = (PersonDetails) MongoDBConnection.getConnection().createQuery(PersonDetails.class).filter("id =", id);
		List<MetricesDetails> metricesDetails = getMetricesDetails(id);
		personalDetails.setMetricesDetail(metricesDetails);
		return personalDetails;
	}
	
	@Override
	public List<PersonDetails> read(){
		List<PersonDetails> personalDetails = (List<PersonDetails>) MongoDBConnection.getConnection().createQuery(PersonDetails.class).asList();
		for (PersonDetails personDetails : personalDetails) {
			personDetails.setMetricesDetail(getMetricesDetails(personDetails.getPersonId()));
		}
		return personalDetails;
	}
	
	private List<MetricesDetails> getMetricesDetails(double id){
			final Query<MetricesDetails> query =  MongoDBConnection.getConnection().createQuery(MetricesDetails.class).filter("id =",id);
			List<MetricesDetails> metricesDetails = query.asList();		 
			return metricesDetails;
	}
	
	@Override
	public List<MetricesDetails> readByTimeRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		final Query<MetricesDetails> query =  MongoDBConnection.getConnection().createQuery(MetricesDetails.class).filter("time >=",startDate).filter("time <=", endDate);
		List<MetricesDetails> metricesDetails = query.asList();		 
		return metricesDetails;		
	}
    
	private boolean personExists(double id){		
		PersonDetails personDetails = null;
		final Query<PersonDetails> query = MongoDBConnection.getConnection().createQuery(PersonDetails.class).filter("id =",id);
		personDetails = query.get();		
		return personDetails != null;		
	}
	
}
