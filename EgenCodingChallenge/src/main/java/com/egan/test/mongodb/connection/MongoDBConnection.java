package com.egan.test.mongodb.connection;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBConnection {
	private static Datastore datastore = null;
	private MongoDBConnection(){
		
	}
	public static Datastore getConnection(){
		return getDataBase("SensorEmul");
	}
	 private static synchronized Datastore getDataBase(String dbName){
		  final Morphia morphia = new Morphia();
		  morphia.mapPackage("com.egan.test");
		  MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
		  
		try {
			 if(datastore == null){
				datastore = morphia.createDatastore(new MongoClient(connectionString), dbName);
			}
			 else return datastore;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  datastore.ensureIndexes();	  
		  return datastore;
	  }	

}
