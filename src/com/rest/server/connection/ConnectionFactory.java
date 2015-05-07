package com.rest.server.connection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ConnectionFactory {
	
	//static reference to itself
    private static ConnectionFactory instance = null;
                
    static boolean thread=true;
  //private constructor
    private ConnectionFactory() {}
    	
    
    public static ConnectionFactory getInstance()   {
    	
    	if(instance== null){
    		
    		if(thread){
    			thread=false;
    			Thread.currentThread();
    			try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    		instance = new ConnectionFactory();
    	}
        return instance;
    }

    public  Response initClient() {
    	
    	
        	Client client = ClientBuilder.newClient();
        	WebTarget target = client
    				.target("http://localhost:8081/REST-PAGINATION/rest/employees");
        	Invocation invocation = target.request(MediaType.APPLICATION_XML)
    				.buildGet();
        	Response response = invocation.invoke();
        	
    	    return response;
    	
    }
}
